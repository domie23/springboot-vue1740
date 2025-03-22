<template>
	<div class="diy_edit page_course_appointment" id="course_appointment_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','laboratory_name') || $check_field('add','laboratory_name') || $check_field('get','laboratory_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								实验室名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_laboratory_name" v-model="form['laboratory_name']" placeholder="请输入实验室名" v-if="(form['laboratory_name'] && $check_field('set','laboratory_name')) || (!form['laboratory_name'] && $check_field('add','laboratory_name'))"  :disabled="disabledObj['laboratory_name_isDisabled']"/>
							<span v-else-if="$check_field('get','laboratory_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','laboratory_number') || $check_field('add','laboratory_number') || $check_field('get','laboratory_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								实验室编号:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_laboratory_number" v-model="form['laboratory_number']" placeholder="请输入实验室编号" v-if="(form['laboratory_number'] && $check_field('set','laboratory_number')) || (!form['laboratory_number'] && $check_field('add','laboratory_number'))"  :disabled="disabledObj['laboratory_number_isDisabled']"/>
							<span v-else-if="$check_field('get','laboratory_number')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','position') || $check_field('add','position') || $check_field('get','position')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								位置:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_position" v-model="form['position']" placeholder="请输入位置" v-if="(form['position'] && $check_field('set','position')) || (!form['position'] && $check_field('add','position'))"  :disabled="disabledObj['position_isDisabled']"/>
							<span v-else-if="$check_field('get','position')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','course_name') || $check_field('add','course_name') || $check_field('get','course_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								课程名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_course_name" v-model="form['course_name']" placeholder="请输入课程名称" v-if="(form['course_name'] && $check_field('set','course_name')) || (!form['course_name'] && $check_field('add','course_name'))"  :disabled="disabledObj['course_name_isDisabled']"/>
							<span v-else-if="$check_field('get','course_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','course_category') || $check_field('add','course_category') || $check_field('get','course_category')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								课程类别:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_course_category" v-model="form['course_category']" placeholder="请输入课程类别" v-if="(form['course_category'] && $check_field('set','course_category')) || (!form['course_category'] && $check_field('add','course_category'))"  :disabled="disabledObj['course_category_isDisabled']"/>
							<span v-else-if="$check_field('get','course_category')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','lecturer') || $check_field('add','lecturer') || $check_field('get','lecturer')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								任课老师:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_lecturer" :disabled="disabledObj['lecturer_isDisabled']" v-model="form['lecturer']" v-if="(form['lecturer'] && $check_field('set','lecturer')) || (!form['lecturer'] && $check_field('add','lecturer'))" >
								<option v-for="o in list_user_lecturer" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','lecturer')">{{ form['lecturer'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','class_time') || $check_field('add','class_time') || $check_field('get','class_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								上课时间:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_class_time" v-model="form['class_time']" placeholder="请输入上课时间" v-if="(form['class_time'] && $check_field('set','class_time')) || (!form['class_time'] && $check_field('add','class_time'))"  :disabled="disabledObj['class_time_isDisabled']"/>
							<span v-else-if="$check_field('get','class_time')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','appointment_period') || $check_field('add','appointment_period') || $check_field('get','appointment_period')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								预约时段:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_appointment_period" v-model="form['appointment_period']" v-if="(form['appointment_period'] && $check_field('set','appointment_period')) || (!form['appointment_period'] && $check_field('add','appointment_period'))" >
								<option v-for="o in list_appointment_period" :value="o['time_interval']">
									{{ o['time_interval'] }}
								</option>
							</select>
							<span v-else-if="$check_field('get','appointment_period')">{{ form['appointment_period'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','number_of_appointments') || $check_field('add','number_of_appointments') || $check_field('get','number_of_appointments')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								预约数:
							</span>
						</div>
								<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_number_of_appointments" v-model="form['number_of_appointments']" v-if="(form['number_of_appointments'] && $check_field('set','number_of_appointments')) || (!form['number_of_appointments'] && $check_field('add','number_of_appointments'))" >
								<option v-for="o in list_number_of_appointments" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','number_of_appointments')">{{ form['number_of_appointments'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','student_name') || $check_field('add','student_name') || $check_field('get','student_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								学生姓名:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_student_name" :disabled="disabledObj['student_name_isDisabled']" v-model="form['student_name']" v-if="(form['student_name'] && $check_field('set','student_name')) || (!form['student_name'] && $check_field('add','student_name'))" >
								<option v-for="o in list_user_student_name" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','student_name')">{{ form['student_name'] }}</span>
						</div>
					</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/course_appointment/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/course_appointment/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>


				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/course_appointment/get_obj?",
				url_add: "~/api/course_appointment/add?",
				url_set: "~/api/course_appointment/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"laboratory_name": "",
							"laboratory_number": "",
							"position": "",
							"course_name": "",
							"course_category": "",
							"lecturer": 0,
							"class_time": "",
							"appointment_period": "",
							"number_of_appointments": "",
							"student_name": 0,
						"course_appointment_id": 0,
				},

				obj: {
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
					"course_appointment_id": 0,
				},

				// 表单字段
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
					"course_appointment_id": 0,
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
	
				// ID字段
				field: "course_appointment_id",

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
					async get_user_session_student_name(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=学生用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["student_name"] = user_id
								_this.disabledObj['student_name' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "student_name") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/course_appointment/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
																				
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }

				if(func){
					func(json);
				}
			},

		},
		created() {
																					this.get_list_user_lecturer();
								this.get_list_appointment_period();
											this.get_user_session_student_name();
					this.get_list_user_student_name();
			},
	}
</script>

<style>




</style>
