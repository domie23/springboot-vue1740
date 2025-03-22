<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="实验资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/student_users/list', 'get')"
				:list="result_student_users_student_name"
				title="学生用户学生姓名"
				source_table="student_users"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/teacher_users/list', 'get')"
				:list="result_teacher_users_teachers_name"
				title="教师用户教师姓名"
				source_table="teacher_users"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/experimental_courses/list', 'get')"
				:list="result_experimental_courses_laboratory_name"
				title="实验课程实验室名"
				source_table="experimental_courses"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/experimental_courses/list', 'get')"
				:list="result_experimental_courses_course_name"
				title="实验课程课程名称"
				source_table="experimental_courses"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/experimental_courses/list', 'get')"
				:list="result_experimental_courses_course_category"
				title="实验课程课程类别"
				source_table="experimental_courses"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/course_appointment/list', 'get')"
				:list="result_course_appointment_laboratory_name"
				title="课程预约实验室名"
				source_table="course_appointment"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/course_appointment/list', 'get')"
				:list="result_course_appointment_course_name"
				title="课程预约课程名称"
				source_table="course_appointment"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/course_appointment/list', 'get')"
				:list="result_course_appointment_course_category"
				title="课程预约课程类别"
				source_table="course_appointment"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/course_appointment/list', 'get')"
				:list="result_course_appointment_appointment_period"
				title="课程预约预约时段"
				source_table="course_appointment"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/appointment_period/list', 'get')"
				:list="result_appointment_period_time_interval"
				title="预约时段预约时段"
				source_table="appointment_period"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/experimental_report/list', 'get')"
				:list="result_experimental_report_course_name"
				title="实验报告课程名称"
				source_table="experimental_report"
			  ></list_result_search>
																														  <list_result_search
				v-if="$check_action('/experimental_results/list', 'get')"
				:list="result_experimental_results_course_name"
				title="实验成绩课程名称"
				source_table="experimental_results"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/device_management/list', 'get')"
				:list="result_device_management_equipment_number"
				title="设备管理设备编号"
				source_table="device_management"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/device_management/list', 'get')"
				:list="result_device_management_device_name"
				title="设备管理设备名称"
				source_table="device_management"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/device_management/list', 'get')"
				:list="result_device_management_equipment_classification"
				title="设备管理设备分类"
				source_table="device_management"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/equipment_borrowing/list', 'get')"
				:list="result_equipment_borrowing_equipment_number"
				title="设备借用设备编号"
				source_table="equipment_borrowing"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_borrowing/list', 'get')"
				:list="result_equipment_borrowing_device_name"
				title="设备借用设备名称"
				source_table="equipment_borrowing"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_borrowing/list', 'get')"
				:list="result_equipment_borrowing_equipment_classification"
				title="设备借用设备分类"
				source_table="equipment_borrowing"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/equipment_return/list', 'get')"
				:list="result_equipment_return_equipment_number"
				title="设备归还设备编号"
				source_table="equipment_return"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_return/list', 'get')"
				:list="result_equipment_return_device_name"
				title="设备归还设备名称"
				source_table="equipment_return"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_return/list', 'get')"
				:list="result_equipment_return_equipment_classification"
				title="设备归还设备分类"
				source_table="equipment_return"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/equipment_maintenance/list', 'get')"
				:list="result_equipment_maintenance_equipment_number"
				title="设备维修设备编号"
				source_table="equipment_maintenance"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_maintenance/list', 'get')"
				:list="result_equipment_maintenance_device_name"
				title="设备维修设备名称"
				source_table="equipment_maintenance"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_maintenance/list', 'get')"
				:list="result_equipment_maintenance_equipment_classification"
				title="设备维修设备分类"
				source_table="equipment_maintenance"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/equipment_shutdown/list', 'get')"
				:list="result_equipment_shutdown_equipment_number"
				title="设备报停设备编号"
				source_table="equipment_shutdown"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_shutdown/list', 'get')"
				:list="result_equipment_shutdown_device_name"
				title="设备报停设备名称"
				source_table="equipment_shutdown"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/equipment_shutdown/list', 'get')"
				:list="result_equipment_shutdown_equipment_classification"
				title="设备报停设备分类"
				source_table="equipment_shutdown"
			  ></list_result_search>
																					  <list_result_search
				v-if="$check_action('/laboratory_information/list', 'get')"
				:list="result_laboratory_information_laboratory_number"
				title="实验室信息实验室编号"
				source_table="laboratory_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/laboratory_information/list', 'get')"
				:list="result_laboratory_information_laboratory_name"
				title="实验室信息实验室名"
				source_table="laboratory_information"
			  ></list_result_search>
												</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_student_users_student_name":[],
															"result_teacher_users_teachers_name":[],
															"result_experimental_courses_laboratory_name":[],
														"result_experimental_courses_course_name":[],
								"result_experimental_courses_course_category":[],
																					"result_course_appointment_laboratory_name":[],
														"result_course_appointment_course_name":[],
								"result_course_appointment_course_category":[],
														"result_course_appointment_appointment_period":[],
															"result_appointment_period_time_interval":[],
															"result_experimental_report_course_name":[],
																														"result_experimental_results_course_name":[],
																								"result_device_management_equipment_number":[],
								"result_device_management_device_name":[],
								"result_device_management_equipment_classification":[],
															"result_equipment_borrowing_equipment_number":[],
								"result_equipment_borrowing_device_name":[],
								"result_equipment_borrowing_equipment_classification":[],
																								"result_equipment_return_equipment_number":[],
								"result_equipment_return_device_name":[],
								"result_equipment_return_equipment_classification":[],
																								"result_equipment_maintenance_equipment_number":[],
								"result_equipment_maintenance_device_name":[],
								"result_equipment_maintenance_equipment_classification":[],
															"result_equipment_shutdown_equipment_number":[],
								"result_equipment_shutdown_device_name":[],
								"result_equipment_shutdown_equipment_classification":[],
																					"result_laboratory_information_laboratory_number":[],
								"result_laboratory_information_laboratory_name":[],
										};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取student_name
	 */
	get_student_users_student_name(){
		let url = "~/api/student_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "student_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_student_users_student_name = json.result.list;
			result_student_users_student_name.map(o => o.title = o['student_name'])
	  			this.result_student_users_student_name = result_student_users_student_name
		 	}
		});
	},
													/**
	 * 获取teachers_name
	 */
	get_teacher_users_teachers_name(){
		let url = "~/api/teacher_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "teachers_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_teacher_users_teachers_name = json.result.list;
			result_teacher_users_teachers_name.map(o => o.title = o['teachers_name'])
	  			this.result_teacher_users_teachers_name = result_teacher_users_teachers_name
		 	}
		});
	},
													/**
	 * 获取laboratory_name
	 */
	get_experimental_courses_laboratory_name(){
		let url = "~/api/experimental_courses/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "laboratory_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_experimental_courses_laboratory_name = json.result.list;
			result_experimental_courses_laboratory_name.map(o => o.title = o['laboratory_name'])
	  			this.result_experimental_courses_laboratory_name = result_experimental_courses_laboratory_name
		 	}
		});
	},
												/**
	 * 获取course_name
	 */
	get_experimental_courses_course_name(){
		let url = "~/api/experimental_courses/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "course_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_experimental_courses_course_name = json.result.list;
			result_experimental_courses_course_name.map(o => o.title = o['course_name'])
	  			this.result_experimental_courses_course_name = result_experimental_courses_course_name
		 	}
		});
	},
						/**
	 * 获取course_category
	 */
	get_experimental_courses_course_category(){
		let url = "~/api/experimental_courses/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "course_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_experimental_courses_course_category = json.result.list;
			result_experimental_courses_course_category.map(o => o.title = o['course_category'])
	  			this.result_experimental_courses_course_category = result_experimental_courses_course_category
		 	}
		});
	},
																			/**
	 * 获取laboratory_name
	 */
	get_course_appointment_laboratory_name(){
		let url = "~/api/course_appointment/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "laboratory_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_course_appointment_laboratory_name = json.result.list;
			result_course_appointment_laboratory_name.map(o => o.title = o['laboratory_name'])
	  			this.result_course_appointment_laboratory_name = result_course_appointment_laboratory_name
		 	}
		});
	},
												/**
	 * 获取course_name
	 */
	get_course_appointment_course_name(){
		let url = "~/api/course_appointment/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "course_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_course_appointment_course_name = json.result.list;
			result_course_appointment_course_name.map(o => o.title = o['course_name'])
	  			this.result_course_appointment_course_name = result_course_appointment_course_name
		 	}
		});
	},
						/**
	 * 获取course_category
	 */
	get_course_appointment_course_category(){
		let url = "~/api/course_appointment/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "course_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_course_appointment_course_category = json.result.list;
			result_course_appointment_course_category.map(o => o.title = o['course_category'])
	  			this.result_course_appointment_course_category = result_course_appointment_course_category
		 	}
		});
	},
												/**
	 * 获取appointment_period
	 */
	get_course_appointment_appointment_period(){
		let url = "~/api/course_appointment/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "appointment_period": this.query.word }, (json) => {
		  if (json.result) {
			var result_course_appointment_appointment_period = json.result.list;
			result_course_appointment_appointment_period.map(o => o.title = o['appointment_period'])
	  			this.result_course_appointment_appointment_period = result_course_appointment_appointment_period
		 	}
		});
	},
													/**
	 * 获取time_interval
	 */
	get_appointment_period_time_interval(){
		let url = "~/api/appointment_period/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "time_interval": this.query.word }, (json) => {
		  if (json.result) {
			var result_appointment_period_time_interval = json.result.list;
			result_appointment_period_time_interval.map(o => o.title = o['time_interval'])
	  			this.result_appointment_period_time_interval = result_appointment_period_time_interval
		 	}
		});
	},
													/**
	 * 获取course_name
	 */
	get_experimental_report_course_name(){
		let url = "~/api/experimental_report/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "course_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_experimental_report_course_name = json.result.list;
			result_experimental_report_course_name.map(o => o.title = o['course_name'])
	  			this.result_experimental_report_course_name = result_experimental_report_course_name
		 	}
		});
	},
																												/**
	 * 获取course_name
	 */
	get_experimental_results_course_name(){
		let url = "~/api/experimental_results/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "course_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_experimental_results_course_name = json.result.list;
			result_experimental_results_course_name.map(o => o.title = o['course_name'])
	  			this.result_experimental_results_course_name = result_experimental_results_course_name
		 	}
		});
	},
																						/**
	 * 获取equipment_number
	 */
	get_device_management_equipment_number(){
		let url = "~/api/device_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_device_management_equipment_number = json.result.list;
			result_device_management_equipment_number.map(o => o.title = o['equipment_number'])
	  			this.result_device_management_equipment_number = result_device_management_equipment_number
		 	}
		});
	},
						/**
	 * 获取device_name
	 */
	get_device_management_device_name(){
		let url = "~/api/device_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "device_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_device_management_device_name = json.result.list;
			result_device_management_device_name.map(o => o.title = o['device_name'])
	  			this.result_device_management_device_name = result_device_management_device_name
		 	}
		});
	},
						/**
	 * 获取equipment_classification
	 */
	get_device_management_equipment_classification(){
		let url = "~/api/device_management/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_device_management_equipment_classification = json.result.list;
			result_device_management_equipment_classification.map(o => o.title = o['equipment_classification'])
	  			this.result_device_management_equipment_classification = result_device_management_equipment_classification
		 	}
		});
	},
													/**
	 * 获取equipment_number
	 */
	get_equipment_borrowing_equipment_number(){
		let url = "~/api/equipment_borrowing/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_borrowing_equipment_number = json.result.list;
			result_equipment_borrowing_equipment_number.map(o => o.title = o['equipment_number'])
	  			this.result_equipment_borrowing_equipment_number = result_equipment_borrowing_equipment_number
		 	}
		});
	},
						/**
	 * 获取device_name
	 */
	get_equipment_borrowing_device_name(){
		let url = "~/api/equipment_borrowing/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "device_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_borrowing_device_name = json.result.list;
			result_equipment_borrowing_device_name.map(o => o.title = o['device_name'])
	  			this.result_equipment_borrowing_device_name = result_equipment_borrowing_device_name
		 	}
		});
	},
						/**
	 * 获取equipment_classification
	 */
	get_equipment_borrowing_equipment_classification(){
		let url = "~/api/equipment_borrowing/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_borrowing_equipment_classification = json.result.list;
			result_equipment_borrowing_equipment_classification.map(o => o.title = o['equipment_classification'])
	  			this.result_equipment_borrowing_equipment_classification = result_equipment_borrowing_equipment_classification
		 	}
		});
	},
																						/**
	 * 获取equipment_number
	 */
	get_equipment_return_equipment_number(){
		let url = "~/api/equipment_return/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_return_equipment_number = json.result.list;
			result_equipment_return_equipment_number.map(o => o.title = o['equipment_number'])
	  			this.result_equipment_return_equipment_number = result_equipment_return_equipment_number
		 	}
		});
	},
						/**
	 * 获取device_name
	 */
	get_equipment_return_device_name(){
		let url = "~/api/equipment_return/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "device_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_return_device_name = json.result.list;
			result_equipment_return_device_name.map(o => o.title = o['device_name'])
	  			this.result_equipment_return_device_name = result_equipment_return_device_name
		 	}
		});
	},
						/**
	 * 获取equipment_classification
	 */
	get_equipment_return_equipment_classification(){
		let url = "~/api/equipment_return/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_return_equipment_classification = json.result.list;
			result_equipment_return_equipment_classification.map(o => o.title = o['equipment_classification'])
	  			this.result_equipment_return_equipment_classification = result_equipment_return_equipment_classification
		 	}
		});
	},
																						/**
	 * 获取equipment_number
	 */
	get_equipment_maintenance_equipment_number(){
		let url = "~/api/equipment_maintenance/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_maintenance_equipment_number = json.result.list;
			result_equipment_maintenance_equipment_number.map(o => o.title = o['equipment_number'])
	  			this.result_equipment_maintenance_equipment_number = result_equipment_maintenance_equipment_number
		 	}
		});
	},
						/**
	 * 获取device_name
	 */
	get_equipment_maintenance_device_name(){
		let url = "~/api/equipment_maintenance/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "device_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_maintenance_device_name = json.result.list;
			result_equipment_maintenance_device_name.map(o => o.title = o['device_name'])
	  			this.result_equipment_maintenance_device_name = result_equipment_maintenance_device_name
		 	}
		});
	},
						/**
	 * 获取equipment_classification
	 */
	get_equipment_maintenance_equipment_classification(){
		let url = "~/api/equipment_maintenance/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_maintenance_equipment_classification = json.result.list;
			result_equipment_maintenance_equipment_classification.map(o => o.title = o['equipment_classification'])
	  			this.result_equipment_maintenance_equipment_classification = result_equipment_maintenance_equipment_classification
		 	}
		});
	},
													/**
	 * 获取equipment_number
	 */
	get_equipment_shutdown_equipment_number(){
		let url = "~/api/equipment_shutdown/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_shutdown_equipment_number = json.result.list;
			result_equipment_shutdown_equipment_number.map(o => o.title = o['equipment_number'])
	  			this.result_equipment_shutdown_equipment_number = result_equipment_shutdown_equipment_number
		 	}
		});
	},
						/**
	 * 获取device_name
	 */
	get_equipment_shutdown_device_name(){
		let url = "~/api/equipment_shutdown/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "device_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_shutdown_device_name = json.result.list;
			result_equipment_shutdown_device_name.map(o => o.title = o['device_name'])
	  			this.result_equipment_shutdown_device_name = result_equipment_shutdown_device_name
		 	}
		});
	},
						/**
	 * 获取equipment_classification
	 */
	get_equipment_shutdown_equipment_classification(){
		let url = "~/api/equipment_shutdown/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "equipment_classification": this.query.word }, (json) => {
		  if (json.result) {
			var result_equipment_shutdown_equipment_classification = json.result.list;
			result_equipment_shutdown_equipment_classification.map(o => o.title = o['equipment_classification'])
	  			this.result_equipment_shutdown_equipment_classification = result_equipment_shutdown_equipment_classification
		 	}
		});
	},
																			/**
	 * 获取laboratory_number
	 */
	get_laboratory_information_laboratory_number(){
		let url = "~/api/laboratory_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "laboratory_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_laboratory_information_laboratory_number = json.result.list;
			result_laboratory_information_laboratory_number.map(o => o.title = o['laboratory_number'])
	  			this.result_laboratory_information_laboratory_number = result_laboratory_information_laboratory_number
		 	}
		});
	},
						/**
	 * 获取laboratory_name
	 */
	get_laboratory_information_laboratory_name(){
		let url = "~/api/laboratory_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "laboratory_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_laboratory_information_laboratory_name = json.result.list;
			result_laboratory_information_laboratory_name.map(o => o.title = o['laboratory_name'])
	  			this.result_laboratory_information_laboratory_name = result_laboratory_information_laboratory_name
		 	}
		});
	},
									
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_student_users_student_name();
														this.get_teacher_users_teachers_name();
														this.get_experimental_courses_laboratory_name();
													this.get_experimental_courses_course_name();
							this.get_experimental_courses_course_category();
																				this.get_course_appointment_laboratory_name();
													this.get_course_appointment_course_name();
							this.get_course_appointment_course_category();
													this.get_course_appointment_appointment_period();
														this.get_appointment_period_time_interval();
														this.get_experimental_report_course_name();
																													this.get_experimental_results_course_name();
																							this.get_device_management_equipment_number();
							this.get_device_management_device_name();
							this.get_device_management_equipment_classification();
														this.get_equipment_borrowing_equipment_number();
							this.get_equipment_borrowing_device_name();
							this.get_equipment_borrowing_equipment_classification();
																							this.get_equipment_return_equipment_number();
							this.get_equipment_return_device_name();
							this.get_equipment_return_equipment_classification();
																							this.get_equipment_maintenance_equipment_number();
							this.get_equipment_maintenance_device_name();
							this.get_equipment_maintenance_equipment_classification();
														this.get_equipment_shutdown_equipment_number();
							this.get_equipment_shutdown_device_name();
							this.get_equipment_shutdown_equipment_classification();
																				this.get_laboratory_information_laboratory_number();
							this.get_laboratory_information_laboratory_name();
									  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_student_users_student_name();
													  this.get_teacher_users_teachers_name();
													  this.get_experimental_courses_laboratory_name();
												  this.get_experimental_courses_course_name();
						  this.get_experimental_courses_course_category();
																			  this.get_course_appointment_laboratory_name();
												  this.get_course_appointment_course_name();
						  this.get_course_appointment_course_category();
												  this.get_course_appointment_appointment_period();
													  this.get_appointment_period_time_interval();
													  this.get_experimental_report_course_name();
																												  this.get_experimental_results_course_name();
																						  this.get_device_management_equipment_number();
						  this.get_device_management_device_name();
						  this.get_device_management_equipment_classification();
													  this.get_equipment_borrowing_equipment_number();
						  this.get_equipment_borrowing_device_name();
						  this.get_equipment_borrowing_equipment_classification();
																						  this.get_equipment_return_equipment_number();
						  this.get_equipment_return_device_name();
						  this.get_equipment_return_equipment_classification();
																						  this.get_equipment_maintenance_equipment_number();
						  this.get_equipment_maintenance_device_name();
						  this.get_equipment_maintenance_equipment_classification();
													  this.get_equipment_shutdown_equipment_number();
						  this.get_equipment_shutdown_device_name();
						  this.get_equipment_shutdown_equipment_classification();
																			  this.get_laboratory_information_laboratory_number();
						  this.get_laboratory_information_laboratory_name();
										},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
