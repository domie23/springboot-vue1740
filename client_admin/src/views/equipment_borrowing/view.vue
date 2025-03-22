<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','equipment_number') || $check_field('add','equipment_number') || $check_field('set','equipment_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备编号" prop="equipment_number">
												<el-input id="equipment_number" v-model="form['equipment_number']" placeholder="请输入设备编号"
							  v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','equipment_number')) || (!form['equipment_borrowing_id'] && $check_field('add','equipment_number'))" :disabled="disabledObj['equipment_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','equipment_number')">{{form['equipment_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','device_name') || $check_field('add','device_name') || $check_field('set','device_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备名称" prop="device_name">
												<el-input id="device_name" v-model="form['device_name']" placeholder="请输入设备名称"
							  v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','device_name')) || (!form['equipment_borrowing_id'] && $check_field('add','device_name'))" :disabled="disabledObj['device_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','device_name')">{{form['device_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','equipment_classification') || $check_field('add','equipment_classification') || $check_field('set','equipment_classification')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备分类" prop="equipment_classification">
												<el-input id="equipment_classification" v-model="form['equipment_classification']" placeholder="请输入设备分类"
							  v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','equipment_classification')) || (!form['equipment_borrowing_id'] && $check_field('add','equipment_classification'))" :disabled="disabledObj['equipment_classification_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','equipment_classification')">{{form['equipment_classification']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','borrowing_teachers') || $check_field('add','borrowing_teachers') || $check_field('set','borrowing_teachers')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="借用教师" prop="borrowing_teachers">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_borrowing_teachers(form['borrowing_teachers']) }}
							<!--<el-input id="business_name" v-model="form['borrowing_teachers']" placeholder="请输入借用教师"-->
							<!--v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','borrowing_teachers')) || (!form['equipment_borrowing_id'] && $check_field('add','borrowing_teachers'))" :disabled="disabledObj['borrowing_teachers_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','borrowing_teachers')">{{form['borrowing_teachers']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','borrowing_teachers')) || (!form['equipment_borrowing_id'] && $check_field('add','borrowing_teachers'))" id="borrowing_teachers" v-model="form['borrowing_teachers']" :disabled="disabledObj['borrowing_teachers_isDisabled']">
								<el-option v-for="o in list_user_borrowing_teachers" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','borrowing_teachers')" id="borrowing_teachers" v-model="form['borrowing_teachers']" :disabled="true">
								<el-option v-for="o in list_user_borrowing_teachers" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="borrowing_teachers" v-model="form['borrowing_teachers']" :disabled="disabledObj['borrowing_teachers_isDisabled']">
							<el-option v-for="o in list_user_borrowing_teachers" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','borrowed_quantity') || $check_field('add','borrowed_quantity') || $check_field('set','borrowed_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="借用数量" prop="borrowed_quantity">
								<el-input-number id="borrowed_quantity" v-model.number="form['borrowed_quantity']"
						v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','borrowed_quantity')) || (!form['equipment_borrowing_id'] && $check_field('add','borrowed_quantity'))" :disabled="disabledObj['borrowed_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','borrowed_quantity')">{{form['borrowed_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
												<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','contact_information')) || (!form['equipment_borrowing_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','borrowing_date') || $check_field('add','borrowing_date') || $check_field('set','borrowing_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="借用日期" prop="borrowing_date">
								<el-date-picker :disabled="disabledObj['borrowing_date_isDisabled']" v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','borrowing_date')) || (!form['equipment_borrowing_id'] && $check_field('add','borrowing_date'))" id="borrowing_date"
						v-model="form['borrowing_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','borrowing_date')">{{form['borrowing_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','borrowing_instructions') || $check_field('add','borrowing_instructions') || $check_field('set','borrowing_instructions')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="借用说明" prop="borrowing_instructions">
								<el-input type="textarea" id="borrowing_instructions" v-model="form['borrowing_instructions']" placeholder="请输入借用说明"
						v-if="user_group === '管理员' || (form['equipment_borrowing_id'] && $check_field('set','borrowing_instructions')) || (!form['equipment_borrowing_id'] && $check_field('add','borrowing_instructions'))" :disabled="disabledObj['borrowing_instructions_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','borrowing_instructions')">{{form['borrowing_instructions']}}</div>
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
				field: "equipment_borrowing_id",
				url_add: "~/api/equipment_borrowing/add?",
				url_set: "~/api/equipment_borrowing/set?",
				url_get_obj: "~/api/equipment_borrowing/get_obj?",
				url_upload: "~/api/equipment_borrowing/upload?",

				query: {
					"equipment_borrowing_id": 0,
				},

				form: {
								"equipment_number":  '', // 设备编号
										"device_name":  '', // 设备名称
										"equipment_classification":  '', // 设备分类
										"borrowing_teachers": 0, // 借用教师
										"borrowed_quantity":  0, // 借用数量
										"contact_information":  '', // 联系方式
										"borrowing_date":  '', // 借用日期
										"borrowing_instructions":  '', // 借用说明
											"equipment_borrowing_id": 0, // ID
						
				},
				disabledObj:{
								"equipment_number_isDisabled": false,
										"device_name_isDisabled": false,
										"equipment_classification_isDisabled": false,
										"borrowing_teachers_isDisabled": false,
					          			"borrowed_quantity_isDisabled": false,
										"contact_information_isDisabled": false,
										"borrowing_date_isDisabled": false,
										"borrowing_instructions_isDisabled": false,
										},

	
		
		
		
					// 用户列表
				list_user_borrowing_teachers: [],
						// 用户组
				group_user_borrowing_teachers: "",
				
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
				/**
			 * 获取教师用户用户列表
			 */
			async get_list_user_borrowing_teachers() {
                // if(this.user_group !== "管理员" && this.form["borrowing_teachers"] === 0) {
                //     this.form["borrowing_teachers"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=教师用户");
                if(json.result && json.result.list){
                    this.list_user_borrowing_teachers = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取教师用户用户组
			 */
			async get_group_user_borrowing_teachers() {
							this.form["borrowing_teachers"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=教师用户");
				if(json.result && json.result.obj){
					this.group_user_borrowing_teachers = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_borrowing_teachers(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_borrowing_teachers.source_table+"/get_obj?"
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
												_this.form["borrowing_teachers"] = id
									_this.disabledObj['borrowing_teachers' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "borrowing_teachers") {
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
					get_user_borrowing_teachers(id){
				var obj = this.list_user_borrowing_teachers.getObj({"user_id":id});
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
														        if (this.form["borrowing_date"].indexOf("-")===-1){
          this.form["borrowing_date"] = this.$toTime(parseInt(this.form["borrowing_date"]),"yyyy-MM-dd")
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


																				        if(this.form["borrowing_date"]=="0000-00-00"){
          this.form["borrowing_date"] = null;
        }
				if(parseInt(this.form["borrowing_date"]) > 9999){
					this.form["borrowing_date"] = this.$toTime(parseInt(this.form["borrowing_date"]),"yyyy-MM-dd")
				}
					


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
					bl = this.$check_action('/equipment_borrowing/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_borrowing/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_borrowing/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_borrowing/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_borrowing/view','get');
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
											this.get_list_user_borrowing_teachers();
					this.get_group_user_borrowing_teachers();
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
