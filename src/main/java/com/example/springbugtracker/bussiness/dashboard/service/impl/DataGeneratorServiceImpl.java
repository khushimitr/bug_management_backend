package com.example.springbugtracker.bussiness.dashboard.service.impl;

import com.example.springbugtracker.bussiness.dashboard.service.DataGeneratorService;
import com.example.springbugtracker.model.domain.entity.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DataGeneratorServiceImpl implements DataGeneratorService {

    public List<HashMap<String, Object>> pieChartData(List<Project> projects) {
        List<HashMap<String, Object>> data = new ArrayList<>();

        projects.forEach(project -> {
            HashMap<String, Object> temp = new HashMap<>();
        });

        return data;
    }

    @Override
    public List<HashMap<String, Object>> BarChartData(List<Project> projects) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> BumpChartData(List<Project> projects) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> StreamChartData(List<Project> projects) {
        return null;
    }

    @Override
    public List<HashMap<String, Object>> TimeRangeChartData(List<Project> projects, Integer userId) {
        return null;
    }

}
