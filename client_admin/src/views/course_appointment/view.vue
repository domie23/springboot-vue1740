<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_name') || $check_field('add','laboratory_name') || $check_field('set','laboratory_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室名" prop="laboratory_name">
												<el-input id="laboratory_name" v-model="form['laboratory_name']" placeholder="请输入实验室名"
							  v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','laboratory_name')) || (!form['course_appointment_id'] && $check_field('add','laboratory_name'))" :disabled="disabledObj['laboratory_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','laboratory_name')">{{form['laboratory_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_number') || $check_field('add','laboratory_number') || $check_field('set','laboratory_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室编号" prop="laboratory_number">
												<el-input id="laboratory_number" v-model="form['laboratory_number']" placeholder="请输入实验室编号"
							  v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','laboratory_number')) || (!form['course_appointment_id'] && $check_field('add','laboratory_number'))" :disabled="disabledObj['laboratory_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','laboratory_number')">{{form['laboratory_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','position') || $check_field('add','position') || $check_field('set','position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="位置" prop="position">
												<el-input id="position" v-model="form['position']" placeholder="请输入位置"
							  v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','position')) || (!form['course_appointment_id'] && $check_field('add','position'))" :disabled="disabledObj['position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','position')">{{form['position']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','course_name') || $check_field('add','course_name') || $check_field('set','course_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程名称" prop="course_name">
												<el-input id="course_name" v-model="form['course_name']" placeholder="请输入课程名称"
							  v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','course_name')) || (!form['course_appointment_id'] && $check_field('add','course_name'))" :disabled="disabledObj['course_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_name')">{{form['course_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','course_category') || $check_field('add','course_category') || $check_field('set','course_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程类别" prop="course_category">
												<el-input id="course_category" v-model="form['course_category']" placeholder="请输入课程类别"
							  v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','course_category')) || (!form['course_appointment_id'] && $check_field('add','course_category'))" :disabled="disabledObj['course_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_category')">{{form['course_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','lecturer') || $check_field('add','lecturer') || $check_field('set','lecturer')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="任课老师" prop="lecturer">
													<el-select v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','lecturer')) || (!form['course_appointment_id'] && $check_field('add','lecturer'))" id="lecturer" v-model="form['lecturer']" :disabled="disabledObj['lecturer_isDisabled']">
							<el-option v-for="o in list_user_lecturer" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','lecturer')" id="lecturer" v-model="form['lecturer']" :disabled="true">
							<el-option v-for="o in list_user_lecturer" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','class_time') || $check_field('add','class_time') || $check_field('set','class_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="上课时间" prop="class_time">
												<el-input id="class_time" v-model="form['class_time']" placeholder="请输入上课时间"
							  v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','class_time')) || (!form['course_appointment_id'] && $check_field('add','class_time'))" :disabled="disabledObj['class_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','class_time')">{{form['class_time']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','appointment_period') || $check_field('add','appointment_period') || $check_field('set','appointment_period')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约时段" prop="appointment_period">
								<el-select id="appointment_period" v-model="form['appointment_period']"
						v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','appointment_period')) || (!form['course_appointment_id'] && $check_field('add','appointment_period'))">
						<el-option v-for="o in list_appointment_period" :key="o['time_interval']" :label="o['time_interval']"
							:value="o['time_interval']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','appointment_period')">{{form['appointment_period']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_appointments') || $check_field('add','number_of_appointments') || $check_field('set','number_of_appointments')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预约数" prop="number_of_appointments">
								<el-select id="number_of_appointments" v-model="form['number_of_appointments']"
						v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','number_of_appointments')) || (!form['course_appointment_id'] && $check_field('add','number_of_appointments'))">
						<el-option v-for="o in list_number_of_appointments" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','number_of_appointments')">{{form['number_of_appointments']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','student_name') || $check_field('add','student_name') || $check_field('set','student_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生姓名" prop="student_name">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_student_name(form['student_name']) }}
							<!--<el-input id="business_name" v-model="form['student_name']" placeholder="请输入学生姓名"-->
							<!--v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','student_name')) || (!form['course_appointment_id'] && $check_field('add','student_name'))" :disabled="disabledObj['student_name_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','student_name')">{{form['student_name']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['course_appointment_id'] && $check_field('set','student_name')) || (!form['course_appointment_id'] && $check_field('add','student_name'))" id="student_name" v-model="form['student_name']" :disabled="disabledObj['student_name_isDisabled']">
								<el-option v-for="o in list_user_student_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','student_name')" id="student_name" v-model="form['student_name']" :disabled="true">
								<el-option v-for="o in list_user_student_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="student_name" v-model="form['student_name']" :disabled="disabledObj['student_name_isDisabled']">
							<el-option v-for="o in list_user_student_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
				</el-form-item>
			</el-col>
	
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "course_appointment_id",
				url_add: "~/api/course_appointment/add?",
				url_set: "~/api/course_appointment/set?",
				url_get_obj: "~/api/course_appointment/get_obj?",
				url_upload: "~/api/course_appointment/upload?",

				query: {
					"course_appointment_id": 0,
				},

				form: {
								"laboratory_name":  '', // 实验室名
										"laboratory_number":  '', // 实验室编号
										"position":  '', // 位置
										"course_name":  '', // 课程名称
										"course_category":  '', // 课程类别
										"lecturer": 0, // 任课老师
										"class_time":  '', // 上课时间
										"appointment_period":  '', // 预约时段
										"number_of_appointments":  '', // 预约数
										"student_name": 0, // 学生姓名
									"examine_state": "未审核",
							"examine_reply": "",
							"course_appointment_id": 0, // ID
						
				},
				disabledObj:{
								"laboratory_name_isDisabled": false,
										"laboratory_number_isDisabled": false,
										"position_isDisabled": false,
										"course_name_isDisabled": false,
										"course_category_isDisabled": false,
										"lecturer_isDisabled": false,
										"class_time_isDisabled": false,
										"appointment_period_isDisabled": false,
										"number_of_appointments_isDisabled": false,
										"student_name_isDisabled": false,
										},

	
		
		
		
		
		
					// 用户列表
				list_user_lecturer: [],
				
						// 预约时段选项列表
				list_appointment_period: [""],
	
						// 预约数选项列表
				list_number_of_appointments: ['1'],
	
		
					// 用户列表
				list_user_student_name: [],
						// 用户组
				group_user_student_name: "",
			
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取教师用户用户列表
			 */
			async get_list_user_lecturer() {
                // if(this.user_group !== "管理员" && this.form["lecturer"] === 0) {
                //     this.form["lecturer"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=教师用户");
                if(json.result && json.result.list){
                    this.list_user_lecturer = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_lecturer(id){
				var obj = this.list_user_lecturer.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
				/**
			 * 获取预约时段列表
			 */
			async get_list_appointment_period() {
				var json = await this.$get("~/api/appointment_period/get_list?");
				if(json.result && json.result.list){
					this.list_appointment_period = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
				/**
			 * 获取学生用户用户列表
			 */
			async get_list_user_student_name() {
                // if(this.user_group !== "管理员" && this.form["student_name"] === 0) {
                //     this.form["student_name"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生用户");
                if(json.result && json.result.list){
                    this.list_user_student_name = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取学生用户用户组
			 */
			async get_group_user_student_name() {
							this.form["student_name"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=学生用户");
				if(json.result && json.result.obj){
					this.group_user_student_name = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_student_name(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_student_name.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["student_name"] = id
									_this.disabledObj['student_name' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "student_name") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_student_name(id){
				var obj = this.list_user_student_name.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
									// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																																					
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																								$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																														


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																				return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/course_appointment/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/course_appointment/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/course_appointment/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/course_appointment/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/course_appointment/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
															this.get_list_user_lecturer();
									this.get_list_appointment_period();
									this.get_list_user_student_name();
					this.get_group_user_student_name();
					},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
