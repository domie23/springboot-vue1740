<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_name') || $check_field('add','laboratory_name') || $check_field('set','laboratory_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室名" prop="laboratory_name">
												<el-input id="laboratory_name" v-model="form['laboratory_name']" placeholder="请输入实验室名"
							  v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','laboratory_name')) || (!form['experimental_report_id'] && $check_field('add','laboratory_name'))" :disabled="disabledObj['laboratory_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','laboratory_name')">{{form['laboratory_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_number') || $check_field('add','laboratory_number') || $check_field('set','laboratory_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室编号" prop="laboratory_number">
												<el-input id="laboratory_number" v-model="form['laboratory_number']" placeholder="请输入实验室编号"
							  v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','laboratory_number')) || (!form['experimental_report_id'] && $check_field('add','laboratory_number'))" :disabled="disabledObj['laboratory_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','laboratory_number')">{{form['laboratory_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','course_name') || $check_field('add','course_name') || $check_field('set','course_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程名称" prop="course_name">
												<el-input id="course_name" v-model="form['course_name']" placeholder="请输入课程名称"
							  v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','course_name')) || (!form['experimental_report_id'] && $check_field('add','course_name'))" :disabled="disabledObj['course_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_name')">{{form['course_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','course_category') || $check_field('add','course_category') || $check_field('set','course_category')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="课程类别" prop="course_category">
												<el-input id="course_category" v-model="form['course_category']" placeholder="请输入课程类别"
							  v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','course_category')) || (!form['experimental_report_id'] && $check_field('add','course_category'))" :disabled="disabledObj['course_category_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','course_category')">{{form['course_category']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','lecturer') || $check_field('add','lecturer') || $check_field('set','lecturer')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="任课老师" prop="lecturer">
													<el-select v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','lecturer')) || (!form['experimental_report_id'] && $check_field('add','lecturer'))" id="lecturer" v-model="form['lecturer']" :disabled="disabledObj['lecturer_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','student_name') || $check_field('add','student_name') || $check_field('set','student_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生姓名" prop="student_name">
													<el-select v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','student_name')) || (!form['experimental_report_id'] && $check_field('add','student_name'))" id="student_name" v-model="form['student_name']" :disabled="disabledObj['student_name_isDisabled']">
							<el-option v-for="o in list_user_student_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','student_name')" id="student_name" v-model="form['student_name']" :disabled="true">
							<el-option v-for="o in list_user_student_name" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','report_upload') || $check_field('add','report_upload') || $check_field('set','report_upload')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="报告上传" prop="report_upload">
												<div v-if="disabledObj['report_upload_isDisabled']">
						<div v-if="$check_field('get','report_upload')">
							<el-button type="primary" @click="$download($fullUrl(form['report_upload']),form['report_upload'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
					<div v-else>
						<el-upload v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','report_upload')) || (!form['experimental_report_id'] && $check_field('add','report_upload'))" class="upload-demo" drag
								   action="" style="max-width: 300px;width: 100%;" :http-request="upload_report_upload" :limit="1" accept="">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
						<div v-else-if="$check_field('get','report_upload')">
							<el-button type="primary" @click="$download($fullUrl(form['report_upload']),form['report_upload'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','student_notes') || $check_field('add','student_notes') || $check_field('set','student_notes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生备注" prop="student_notes">
								<el-input type="textarea" id="student_notes" v-model="form['student_notes']" placeholder="请输入学生备注"
						v-if="user_group === '管理员' || (form['experimental_report_id'] && $check_field('set','student_notes')) || (!form['experimental_report_id'] && $check_field('add','student_notes'))" :disabled="disabledObj['student_notes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_notes')">{{form['student_notes']}}</div>
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
				field: "experimental_report_id",
				url_add: "~/api/experimental_report/add?",
				url_set: "~/api/experimental_report/set?",
				url_get_obj: "~/api/experimental_report/get_obj?",
				url_upload: "~/api/experimental_report/upload?",

				query: {
					"experimental_report_id": 0,
				},

				form: {
								"laboratory_name":  '', // 实验室名
										"laboratory_number":  '', // 实验室编号
										"course_name":  '', // 课程名称
										"course_category":  '', // 课程类别
										"lecturer": 0, // 任课老师
										"student_name": 0, // 学生姓名
										"report_upload":  '', // 报告上传
										"student_notes":  '', // 学生备注
											"experimental_report_id": 0, // ID
						
				},
				disabledObj:{
								"laboratory_name_isDisabled": false,
										"laboratory_number_isDisabled": false,
										"course_name_isDisabled": false,
										"course_category_isDisabled": false,
										"lecturer_isDisabled": false,
										"student_name_isDisabled": false,
										"report_upload_isDisabled": false,
										"student_notes_isDisabled": false,
										},

	
		
		
		
		
					// 用户列表
				list_user_lecturer: [],
				
					// 用户列表
				list_user_student_name: [],
				
		
	
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
			 * 上传报告上传
			 * @param {Object} param 文件参数
			 */
			upload_report_upload(param){
						this.uploadFile(param.file, "report_upload");
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
					bl = this.$check_action('/experimental_report/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/experimental_report/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/experimental_report/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/experimental_report/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/experimental_report/view','get');
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
								this.get_list_user_student_name();
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
