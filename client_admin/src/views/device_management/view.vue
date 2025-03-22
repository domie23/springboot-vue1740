<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','equipment_diagram') || $check_field('add','equipment_diagram') || $check_field('set','equipment_diagram')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备图" prop="equipment_diagram">
								<el-upload :disabled="disabledObj['equipment_diagram_isDisabled']" id="equipment_diagram" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_equipment_diagram"
						:show-file-list="false" v-if="user_group === '管理员' || (form['device_management_id'] && $check_field('set','equipment_diagram')) || (!form['device_management_id'] && $check_field('add','equipment_diagram'))">
						<img v-if="form['equipment_diagram']" :src="$fullUrl(form['equipment_diagram'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','equipment_diagram')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['equipment_diagram'])" :preview-src-list="[$fullUrl(form['equipment_diagram'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','equipment_number') || $check_field('add','equipment_number') || $check_field('set','equipment_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备编号" prop="equipment_number">
												<el-input id="equipment_number" v-model="form['equipment_number']" placeholder="请输入设备编号"
							  v-if="user_group === '管理员' || (form['device_management_id'] && $check_field('set','equipment_number')) || (!form['device_management_id'] && $check_field('add','equipment_number'))" :disabled="disabledObj['equipment_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','equipment_number')">{{form['equipment_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','device_name') || $check_field('add','device_name') || $check_field('set','device_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备名称" prop="device_name">
												<el-input id="device_name" v-model="form['device_name']" placeholder="请输入设备名称"
							  v-if="user_group === '管理员' || (form['device_management_id'] && $check_field('set','device_name')) || (!form['device_management_id'] && $check_field('add','device_name'))" :disabled="disabledObj['device_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','device_name')">{{form['device_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','equipment_classification') || $check_field('add','equipment_classification') || $check_field('set','equipment_classification')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="设备分类" prop="equipment_classification">
								<el-select id="equipment_classification" v-model="form['equipment_classification']"
						v-if="user_group === '管理员' || (form['device_management_id'] && $check_field('set','equipment_classification')) || (!form['device_management_id'] && $check_field('add','equipment_classification'))">
						<el-option v-for="o in list_equipment_classification" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','equipment_classification')">{{form['equipment_classification']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','inventory_quantity') || $check_field('add','inventory_quantity') || $check_field('set','inventory_quantity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="库存数量" prop="inventory_quantity">
								<el-input-number id="inventory_quantity" v-model.number="form['inventory_quantity']"
						v-if="user_group === '管理员' || (form['device_management_id'] && $check_field('set','inventory_quantity')) || (!form['device_management_id'] && $check_field('add','inventory_quantity'))" :disabled="disabledObj['inventory_quantity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','inventory_quantity')">{{form['inventory_quantity']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detailed_introduction') || $check_field('add','detailed_introduction') || $check_field('set','detailed_introduction')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="详细介绍" prop="detailed_introduction">
					<quill-editor v-model.number="form['detailed_introduction']"
						v-if="user_group === '管理员' || (form['device_management_id'] && $check_field('set','detailed_introduction')) || (!form['device_management_id'] && $check_field('add','detailed_introduction')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','detailed_introduction')" v-html="form['detailed_introduction']"></div>
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
				field: "device_management_id",
				url_add: "~/api/device_management/add?",
				url_set: "~/api/device_management/set?",
				url_get_obj: "~/api/device_management/get_obj?",
				url_upload: "~/api/device_management/upload?",

				query: {
					"device_management_id": 0,
				},

				form: {
								"equipment_diagram":  '', // 设备图
										"equipment_number":  '', // 设备编号
										"device_name":  '', // 设备名称
										"equipment_classification":  '', // 设备分类
										"inventory_quantity":  0, // 库存数量
										"detailed_introduction":  '', // 详细介绍
											"device_management_id": 0, // ID
						
				},
				disabledObj:{
								"equipment_diagram_isDisabled": false,
										"equipment_number_isDisabled": false,
										"device_name_isDisabled": false,
										"equipment_classification_isDisabled": false,
					          			"inventory_quantity_isDisabled": false,
										"detailed_introduction_isDisabled": false,
										},

	
		
		
						// 设备分类选项列表
				list_equipment_classification: ['化学','物理','其他'],
	
		
		
	
			}
		},
		methods: {


				/**
			 * 上传设备图
			 * @param {Object} param 图片参数
			 */
			upload_equipment_diagram(param){
						this.uploadFile(param.file, "equipment_diagram");
					},
	
	
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																																					
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
					bl = this.$check_action('/device_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/device_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/device_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/device_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/device_management/view','get');
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
