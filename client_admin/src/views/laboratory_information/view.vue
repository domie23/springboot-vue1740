<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_diagram') || $check_field('add','laboratory_diagram') || $check_field('set','laboratory_diagram')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室图" prop="laboratory_diagram">
								<el-upload :disabled="disabledObj['laboratory_diagram_isDisabled']" id="laboratory_diagram" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_laboratory_diagram"
						:show-file-list="false" v-if="user_group === '管理员' || (form['laboratory_information_id'] && $check_field('set','laboratory_diagram')) || (!form['laboratory_information_id'] && $check_field('add','laboratory_diagram'))">
						<img v-if="form['laboratory_diagram']" :src="$fullUrl(form['laboratory_diagram'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','laboratory_diagram')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['laboratory_diagram'])" :preview-src-list="[$fullUrl(form['laboratory_diagram'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_number') || $check_field('add','laboratory_number') || $check_field('set','laboratory_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室编号" prop="laboratory_number">
												<el-input id="laboratory_number" v-model="form['laboratory_number']" placeholder="请输入实验室编号"
							  v-if="user_group === '管理员' || (form['laboratory_information_id'] && $check_field('set','laboratory_number')) || (!form['laboratory_information_id'] && $check_field('add','laboratory_number'))" :disabled="disabledObj['laboratory_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','laboratory_number')">{{form['laboratory_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','laboratory_name') || $check_field('add','laboratory_name') || $check_field('set','laboratory_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="实验室名" prop="laboratory_name">
												<el-input id="laboratory_name" v-model="form['laboratory_name']" placeholder="请输入实验室名"
							  v-if="user_group === '管理员' || (form['laboratory_information_id'] && $check_field('set','laboratory_name')) || (!form['laboratory_information_id'] && $check_field('add','laboratory_name'))" :disabled="disabledObj['laboratory_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','laboratory_name')">{{form['laboratory_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','position') || $check_field('add','position') || $check_field('set','position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="位置" prop="position">
												<el-input id="position" v-model="form['position']" placeholder="请输入位置"
							  v-if="user_group === '管理员' || (form['laboratory_information_id'] && $check_field('set','position')) || (!form['laboratory_information_id'] && $check_field('add','position'))" :disabled="disabledObj['position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','position')">{{form['position']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','capacity') || $check_field('add','capacity') || $check_field('set','capacity')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="容纳人数" prop="capacity">
								<el-input-number id="capacity" v-model.number="form['capacity']"
						v-if="user_group === '管理员' || (form['laboratory_information_id'] && $check_field('set','capacity')) || (!form['laboratory_information_id'] && $check_field('add','capacity'))" :disabled="disabledObj['capacity_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','capacity')">{{form['capacity']}}</div>
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
				field: "laboratory_information_id",
				url_add: "~/api/laboratory_information/add?",
				url_set: "~/api/laboratory_information/set?",
				url_get_obj: "~/api/laboratory_information/get_obj?",
				url_upload: "~/api/laboratory_information/upload?",

				query: {
					"laboratory_information_id": 0,
				},

				form: {
								"laboratory_diagram":  '', // 实验室图
										"laboratory_number":  '', // 实验室编号
										"laboratory_name":  '', // 实验室名
										"position":  '', // 位置
										"capacity":  0, // 容纳人数
											"laboratory_information_id": 0, // ID
						
				},
				disabledObj:{
								"laboratory_diagram_isDisabled": false,
										"laboratory_number_isDisabled": false,
										"laboratory_name_isDisabled": false,
										"position_isDisabled": false,
					          			"capacity_isDisabled": false,
										},

	
		
		
		
		
	
			}
		},
		methods: {


				/**
			 * 上传实验室图
			 * @param {Object} param 图片参数
			 */
			upload_laboratory_diagram(param){
						this.uploadFile(param.file, "laboratory_diagram");
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
					bl = this.$check_action('/laboratory_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/laboratory_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/laboratory_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/laboratory_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/laboratory_information/view','get');
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
