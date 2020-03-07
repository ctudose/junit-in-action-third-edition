/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */

package com.manning.junitbook.ch02.assertions;

import java.util.ArrayList;
import java.util.List;

public class SUT {
    private String systemName;
    private boolean isVerified;
    private List<Job> jobs = new ArrayList<>();
    private Job currentJob;

    public SUT(String systemName) {
        this.systemName = systemName;
        this.isVerified = false;
    }

    public String getSystemName() {
        return systemName;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void verify() {
        this.isVerified = true;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public Object[] getJobsAsArray() {
        return jobs.toArray();
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void run() {
        if (jobs.size() > 0) {
            currentJob = jobs.remove(0);
            System.out.println("Running job: " + currentJob);
            return;
        }
        throw new NoJobException("No jobs on the execution list!");
    }

    public void run(int jobDuration) throws InterruptedException {
        if (jobs.size() > 0) {
            currentJob = jobs.remove(0);
            System.out.println("Running job: " + currentJob + " lasts " + jobDuration + " milliseconds");
            Thread.sleep(jobDuration);
            return;
        }
        throw new NoJobException("No jobs on the execution list!");
    }
}
