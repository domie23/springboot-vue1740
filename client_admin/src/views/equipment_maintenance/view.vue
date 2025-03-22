<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','equipment_number') || $check_field('add','equipment_number') || $check_field('set','equipment_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备编号" prop="equipment_number">
												<el-input id="equipment_number" v-model="form['equipment_number']" placeholder="请输入设备编号"
							  v-if="user_group === '管理员' || (form['equipment_maintenance_id'] && $check_field('set','equipment_number')) || (!form['equipment_maintenance_id'] && $check_field('add','equipment_number'))" :disabled="disabledObj['equipment_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','equipment_number')">{{form['equipment_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','device_name') || $check_field('add','device_name') || $check_field('set','device_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备名称" prop="device_name">
												<el-input id="device_name" v-model="form['device_name']" placeholder="请输入设备名称"
							  v-if="user_group === '管理员' || (form['equipment_maintenance_id'] && $check_field('set','device_name')) || (!form['equipment_maintenance_id'] && $check_field('add','device_name'))" :disabled="disabledObj['device_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','device_name')">{{form['device_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','equipment_classification') || $check_field('add','equipment_classification') || $check_field('set','equipment_classification')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备分类" prop="equipment_classification">
												<el-input id="equipment_classification" v-model="form['equipment_classification']" placeholder="请输入设备分类"
							  v-if="user_group === '管理员' || (form['equipment_maintenance_id'] && $check_field('set','equipment_classification')) || (!form['equipment_maintenance_id'] && $check_field('add','equipment_classification'))" :disabled="disabledObj['equipment_classification_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','equipment_classification')">{{form['equipment_classification']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','repair_date') || $check_field('add','repair_date') || $check_field('set','repair_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="维修日期" prop="repair_date">
								<el-date-picker :disabled="disabledObj['repair_date_isDisabled']" v-if="user_group === '管理员' || (form['equipment_maintenance_id'] && $check_field('set','repair_date')) || (!form['equipment_maintenance_id'] && $check_field('add','repair_date'))" id="repair_date"
						v-model="form['repair_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','repair_date')">{{form['repair_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','maintenance_instructions') || $check_field('add','maintenance_instructions') || $check_field('set','maintenance_instructions')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="维修说明" prop="maintenance_instructions">
												<el-input id="maintenance_instructions" v-model="form['maintenance_instructions']" placeholder="请输入维修说明"
							  v-if="user_group === '管理员' || (form['equipment_maintenance_id'] && $check_field('set','maintenance_instructions')) || (!form['equipment_maintenance_id'] && $check_field('add','maintenance_instructions'))" :disabled="disabledObj['maintenance_instructions_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','maintenance_instructions')">{{form['maintenance_instructions']}}</div>
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
				field: "equipment_maintenance_id",
				url_add: "~/api/equipment_maintenance/add?",
				url_set: "~/api/equipment_maintenance/set?",
				url_get_obj: "~/api/equipment_maintenance/get_obj?",
				url_upload: "~/api/equipment_maintenance/upload?",

				query: {
					"equipment_maintenance_id": 0,
				},

				form: {
								"equipment_number":  '', // 设备编号
										"device_name":  '', // 设备名称
										"equipment_classification":  '', // 设备分类
										"repair_date":  '', // 维修日期
										"maintenance_instructions":  '', // 维修说明
											"equipment_maintenance_id": 0, // ID
						
				},
				disabledObj:{
								"equipment_number_isDisabled": false,
										"device_name_isDisabled": false,
										"equipment_classification_isDisabled": false,
										"repair_date_isDisabled": false,
										"maintenance_instructions_isDisabled": false,
										},

	
		
		
		
		
	
			}
		},
		methods: {


	
	
			
	
			
	
			
	
			
	
		
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
								        if (this.form["repair_date"].indexOf("-")===-1){
          this.form["repair_date"] = this.$toTime(parseInt(this.form["repair_date"]),"yyyy-MM-dd")
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


											        if(this.form["repair_date"]=="0000-00-00"){
          this.form["repair_date"] = null;
        }
				if(parseInt(this.form["repair_date"]) > 9999){
					this.form["repair_date"] = this.$toTime(parseInt(this.form["repair_date"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/equipment_maintenance/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_maintenance/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_maintenance/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_maintenance/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/equipment_maintenance/view','get');
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
