#!/usr/bin/env bash
mvn -Dtest=TestSuiteMac clean test
allure serve allure-results