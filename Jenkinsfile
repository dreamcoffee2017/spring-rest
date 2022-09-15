#!/usr/bin/env groovy
pipeline {
    agent any

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