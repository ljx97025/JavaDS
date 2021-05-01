package com.jxl.dao;

import com.jxl.entity.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName : JobDao
 * @Author : ljx
 * @Date: 2021/4/6 9:29
 * @Description :
 */
public interface JobDao {
    public Integer insertJob(Job job);
    public Integer deleteJobById(String jobId);
    // 多个参数传递，需要写别名， 保证映射文件可以读取到
    public Integer updateJobById(@Param("jobId") String jobId, @Param("money") Integer money);
    // 可以使用对象传递，此时不需要写别名，只需要映射文件中设置所需对象的属性名
    public Integer updateJobByIdt(Job job);
    //使用动态sql set标签实现插入
    public Integer updateJobByIdUseSetsql(@Param("job") Job job);
    public List<Job> findJonBySalary(@Param("minS") Integer minS, @Param("maxS") Integer maxS);
    public List<Job> findJobByIDAndSalary(@Param("minS") Integer minS, @Param("maxS") Integer maxS);

    public List<Job> findJobByJobIDLike(@Param("job_ids") List<String> job_ids);

    public List<Job> findJobByChoose(@Param("minS") Integer minS, @Param("maxS") Integer maxS);
}
