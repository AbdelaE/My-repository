package et.gov.empProfile.controller;

import et.gov.empProfile.entity.Department;
import et.gov.empProfile.entity.Job;
import et.gov.empProfile.exception.DataNotFoundException;
import et.gov.empProfile.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/saveJob")
    public ResponseEntity<Job> saveJob(@RequestBody @Valid Job job) {
        Job saveJob = jobService.saveJob(job);
        return new ResponseEntity<>(saveJob, HttpStatus.CREATED);

    }

    @GetMapping("/allJob")
    public ResponseEntity<List<Job>> findAllJob() {
        List<Job> jobs = jobService.finAllDEp();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/getJobById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) throws DataNotFoundException{
        Job jobByid = jobService.findById(id);
        return new ResponseEntity<>(jobByid, HttpStatus.OK);
    }

    @PutMapping("/updateJobById/{id}")
    public ResponseEntity<Job> updateDepartment(@PathVariable int id, @RequestBody @Valid Job job) throws DataNotFoundException{
        job.setId(id);
        Job updateJob = jobService.updateDepartment(job);
        return new ResponseEntity<Job>(updateJob, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteJobById/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable int id) {
        jobService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
