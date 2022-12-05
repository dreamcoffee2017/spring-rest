package com.dreamcoffee.spring.boot.demo;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.common.RequestStatus;
import com.cdancy.jenkins.rest.features.JobsApi;
import org.apache.commons.io.IOUtils;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Test {
    private static final String project = "odm";
    private static final String cluster = "WCMRCluster_c02";
    private static final String cluster_id = "c02";
    private static final String[] regionTypes = {"1_PrimaryRegion", "2_BackupRegion"};
    private static final String[] regions = {"eu-west-1", "eu-west-2"};
    private static final String[] envs = {"ppe"};
    private static final String folderTemp = "WF-V2/%s/%s/%s/%s/%s/2_InitialSetup_ODM_Ext/1_iRPMIntegration";
    private static final String[] jobs = {"1_1_irpm-integration-build-pipeline", "1_2_irpm-integration-destroy-pipeline"};
    private static final String jenkinsfileTemp = "%s/jenkins/%s/%s.Jenkinsfile";

    public static void main(String[] args) {
        try (JenkinsClient client = JenkinsClient.builder().modules(new SLF4JLoggingModule())
                .endPoint("http://a250212-cicd.edp-cicd.aws-int.thomsonreuters.com")
                .credentials("frank_chen:epam.2010").build();
             InputStream fis = Test.class.getClassLoader().getResourceAsStream("folder.xml");
             InputStream jis = Test.class.getClassLoader().getResourceAsStream("job.xml")) {

            JobsApi jobsApi = client.api().jobsApi();
            String folderXml = IOUtils.toString(Objects.requireNonNull(fis), StandardCharsets.UTF_8);
            String jobXml = IOUtils.toString(Objects.requireNonNull(jis), StandardCharsets.UTF_8);

            for (int i = 0; i < regionTypes.length; i++) {
                for (String env : envs) {
                    String folder = String.format(folderTemp, project.toUpperCase(), cluster, regionTypes[i], regions[i], env);
                    createFolder(jobsApi, folderXml, folder);

                    for (int j = 0; j < jobs.length; j++) {
                        String jenkinsfile = String.format(jenkinsfileTemp, project, getEnvDir(env, i), getFilename(j));
                        jobXml = String.format(jobXml, cluster_id, jenkinsfile);
                        RequestStatus result = jobsApi.create(folder, jobs[j], jobXml);
                        System.out.printf("Create job %s/%s%n", folder, jobs[j]);
                        if (!result.value()) throw new Exception(result.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createFolder(JobsApi jobsApi, String folderXml, String folder) throws Exception {
        String p = "";
        for (String f : folder.split("/")) {
            if (jobsApi.jobInfo(p, f) == null) {
                RequestStatus result = jobsApi.create(p, f, folderXml);
                if (!result.value()) throw new Exception(result.toString());
            }
            p += "/" + f;
        }
    }

    private static String getEnvDir(String env, int regionIdx) {
        String backupStr = regionIdx == 0 ? "" : "-backup";
        if (env.equals("prod")) {
            return env + backupStr;
        } else {
            return "nonprod" + backupStr + "/" + env;
        }
    }

    private static String getFilename(int jobIdx) {
        return jobIdx == 0 ? "build" : "destroy";
    }
}
