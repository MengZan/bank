package com.bankofshanghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class ModelController {
	
	@RequestMapping(value = "/models", method = RequestMethod.GET )
	@ResponseBody
	public String listAllModels(){
		return "{\"status\":0,\"msg\":\"\",\"data\":[{\"id\":1,\"model\":\"Firstmodel\",\"url\":\"/ajax/models/1\",\"created_at\":\"2015-08-05T08:40:51.620Z\",\"status\":201,\"template_id\":\"213\",\"template_name\":\"svm-type-one\"},{\"id\":2,\"model\":\"Iamacloneofthefirstmodel\",\"url\":\"/ajax/models/2\",\"created_at\":\"2016-08-05T08:40:51.620Z\",\"status\":200,\"template_id\":\"213\",\"template_name\":\"svm-type-one\"},{\"id\":3,\"model\":\"Tryanewtemplate\",\"url\":\"/ajax/models/3\",\"created_at\":\"2016-08-07T08:40:51.620Z\",\"status\":200,\"template_id\":\"215\",\"template_name\":\"svm-type-two\"}]}";
	}
	
	@RequestMapping(value = "/models", method = RequestMethod.POST )
	@ResponseBody
	public String createModel(){
		return "{\"status\":0,\"msg\":\"\",\"data\":{\"model\":\"Wantanewmodel?\",\"url\":\"/ajax/models/5\",\"created_at\":\"2016-08-07T08:40:51.620Z\",\"status\":100,\"template_id\":\"215\",\"template_name\":\"svm-type-two\",\"parameters\":{\"scale\":true,\"kernel\":\"polynomial\",\"degree\":3,\"gamma\":0.2134,\"coef0\":0,\"cost\":1,\"nu\":0.11,\"tolerance\":0.001,\"epsilon\":0.1,\"shrinking\":true,\"cross\":0}}}";
	}
	
	@RequestMapping(value = "/models/{model_id}", method = RequestMethod.GET )
	@ResponseBody
	public String modelDetail1(){
		return "{\"status\":0,\"msg\":\"\",\"data\":{\"model\":\"Tryanewtemplate\",\"url\":\"/ajax/models/3\",\"created_at\":\"2016-08-07T08:40:51.620Z\",\"status\":200,\"template_id\":\"215\",\"template_name\":\"svm-type-two\",\"parameters\":{\"scale\":true,\"kernel\":\"polynomial\",\"degree\":3,\"gamma\":0.2134,\"coef0\":0,\"cost\":1,\"nu\":0.11,\"tolerance\":0.001,\"epsilon\":0.1,\"shrinking\":true,\"cross\":0},\"training_history\":[{\"status\":200,\"began_at\":\"2016-07-08T08:40:51.620Z\",\"ended_at\":\"2016-07-08T12:40:51.620Z\",\"dataset\":{\"began_at\":\"2016-06-08T08:40:51.620Z\",\"ended_at\":\"2016-07-07T12:40:51.620Z\"}},{\"status\":300,\"began_at\":\"2016-08-08T08:40:51.620Z\",\"ended_at\":\"2016-08-08T12:40:51.620Z\",\"dataset\":{\"began_at\":\"2016-07-08T08:40:51.620Z\",\"ended_at\":\"2016-08-07T12:40:51.620Z\"}}]}}";
	}
	
	@RequestMapping(value = "/models/{model_id}", method = RequestMethod.DELETE )
	@ResponseBody
	public String deleteModel(){
		return "";
	}
	
	@RequestMapping(value = "/models/jobs", method = RequestMethod.GET )
	@ResponseBody
	public String listAllJobs(){
		return "{\"status\":0,\"msg\":\"\",\"data\":[{\"id\":1,\"job\":\"TraintheFirstmodel\",\"url\":\"/ajax/models/jobs/1\",\"created_at\":\"2015-08-05T08:40:51.620Z\",\"status\":200},{\"id\":2,\"job\":\"Trainacrazyone\",\"url\":\"/ajax/models/jobs/2\",\"created_at\":\"2016-08-07T08:40:51.620Z\",\"status\":100}]}";
	}
	
	@RequestMapping(value = "/models/jobs", method = RequestMethod.POST )
	@ResponseBody
	public String createJob(){
		return "{\"status\":0,\"msg\":\"\",\"data\":{\"job\":\"Giveatry\",\"url\":\"/ajax/models/jobs/5\",\"model\":{\"model\":\"Firstmodel\",\"url\":\"/ajax/models/1\",\"created_at\":\"2015-08-05T08:40:51.620Z\",\"status\":201,\"template_id\":\"213\",\"template_name\":\"svm-type-one\"},\"created_at\":\"2016-08-07T08:40:51.620Z\",\"status\":100,\"began_at\":\"2016-08-08T08:40:51.620Z\",\"dataset\":{\"began_at\":\"2016-07-08T08:40:51.620Z\",\"ended_at\":\"2016-08-07T12:40:51.620Z\"}}}";
	}
	
	@RequestMapping(value = "/models/jobs/{job_id}", method = RequestMethod.GET )
	@ResponseBody
	public String jobDetail(){
		return "{\"status\":0,\"msg\":\"\",\"data\":{\"job\":\"Detail\",\"url\":\"/ajax/models/jobs/4\",\"model\":{\"model\":\"Firstmodel\",\"url\":\"/ajax/models/1\",\"created_at\":\"2015-08-05T08:40:51.620Z\",\"status\":201,\"template_id\":\"213\",\"template_name\":\"svm-type-one\"},\"created_at\":\"2016-08-07T08:40:51.620Z\",\"status\":200,\"began_at\":\"2016-08-08T08:40:51.620Z\",\"ended_at\":\"2016-08-08T12:40:51.620Z\",\"dataset\":{\"began_at\":\"2016-07-08T08:40:51.620Z\",\"ended_at\":\"2016-08-07T12:40:51.620Z\"}}}";
	}
	
	
}
