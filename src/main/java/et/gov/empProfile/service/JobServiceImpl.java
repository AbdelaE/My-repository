package et.gov.empProfile.service;

import et.gov.empProfile.entity.Job;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.repository.JobREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobREpository jobREpository;

    @Override
    public Job saveJob(Job job) {
        return jobREpository.save(job);
    }

    @Override
    public List<Job> finAllDEp() {
        return jobREpository.findAll();
    }

    @Override
    public Job findById(int id) throws DataNotFoundException {
        Job jobById =  jobREpository.findById(id).orElse(null);
        if (jobById == null){
            throw new DataNotFoundException("there is no data wirh id"+id);
        }
        return jobById;
    }

    @Override
    public Job updateDepartment(Job job) throws DataNotFoundException {
        Job savedJob = jobREpository.findById(job.getId()).orElse(null);
        if (savedJob == null){
            throw new DataNotFoundException("there is no data wirh id"+job.getId());
        }
        savedJob.setJob_Title(job.getJob_Title());
        savedJob.setDescription(job.getDescription());
        return jobREpository.save(savedJob);
    }

    @Override
    public void deleteUser(int id) {
        jobREpository.deleteById(id);
    }
}
