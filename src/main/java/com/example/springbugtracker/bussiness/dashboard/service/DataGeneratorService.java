package com.example.springbugtracker.bussiness.dashboard.service;

import com.example.springbugtracker.model.domain.entity.Project;

import java.util.HashMap;
import java.util.List;

public interface DataGeneratorService {

    List<HashMap<String, Object>> pieChartData(List<Project> projects);

    List<HashMap<String, Object>> BarChartData(List<Project> projects);

    List<HashMap<String, Object>> BumpChartData(List<Project> projects);

    List<HashMap<String, Object>> StreamChartData(List<Project> projects);

    List<HashMap<String, Object>> TimeRangeChartData(List<Project> projects, Integer userId);



}
