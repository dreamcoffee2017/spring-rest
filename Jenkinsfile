#!/usr/bin/env groovy
pipeline {
    agent any

    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '3'))
        skipDefaultCheckout()
    }

    stages {
        stage('Build') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'master']],
                    extensions: [[$class: 'CleanCheckout']],
                    userRemoteConfigs: [[url: 'https://github.com/dreamcoffee2017/spring-boot-demo.git']]
                ])
            }
        }
    }
}