package et.gov.empProfile.service;

import et.gov.empProfile.entity.Job;
import et.gov.empProfile.exception.DataNotFoundException;

import java.util.List;

public interface JobService {
    Job saveJob(Job job);

    List<Job> finAllDEp();

    Job findById(int id) throws DataNotFoundException;

    Job updateDepartment(Job job) throws DataNotFoundException;

    void deleteUser(int id);
}
