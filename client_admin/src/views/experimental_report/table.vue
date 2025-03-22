<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


													<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="课程名称">
									<el-input v-model="query.course_name"></el-input>
								</el-form-item>
				</el-col>
																						<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/experimental_report/table','add') || $check_action('/experimental_report/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/experimental_report/table','del') || $check_action('/experimental_report/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="laboratory_name" @sort-change="$sortChange" label="实验室名"
				v-if="user_group == '管理员' || $check_field('get','laboratory_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="laboratory_number" @sort-change="$sortChange" label="实验室编号"
				v-if="user_group == '管理员' || $check_field('get','laboratory_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="course_name" @sort-change="$sortChange" label="课程名称"
				v-if="user_group == '管理员' || $check_field('get','course_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="course_category" @sort-change="$sortChange" label="课程类别"
				v-if="user_group == '管理员' || $check_field('get','course_category')" min-width="200">
					</el-table-column>
					<el-table-column prop="lecturer" @sort-change="$sortChange" label="任课老师"
				v-if="user_group == '管理员' || $check_field('get','lecturer')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_lecturer(scope.row['lecturer']) }}
				</template>
					</el-table-column>
					<el-table-column prop="student_name" @sort-change="$sortChange" label="学生姓名"
				v-if="user_group == '管理员' || $check_field('get','student_name')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_student_name(scope.row['student_name']) }}
				</template>
					</el-table-column>
					<el-table-column prop="report_upload" @sort-change="$sortChange" label="报告上传"
				v-if="user_group == '管理员' || $check_field('get','report_upload')" min-width="200">
						<template slot-scope="scope">
					<a :href="$fullUrl(scope.row['report_upload'])" target="_blank" style="color: rgb(64, 158, 255);">点击下载</a>
				</template>
					</el-table-column>
					<el-table-column prop="student_notes" @sort-change="$sortChange" label="学生备注"
				v-if="user_group == '管理员' || $check_field('get','student_notes')" min-width="200">
					</el-table-column>
	



            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/experimental_report/table','set') || $check_action('/experimental_report/view','set') || $check_action('/experimental_report/view','get') || $check_action('/输入成绩/table','add') || $check_action('/输入成绩/view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/experimental_report/table','set') || $check_action('/experimental_report/view','set') || $check_action('/experimental_report/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
						<!--跨表按钮-->
							<el-button class="el-button el-button--small is-plain el-button--default" style="margin: 5px !important;" size="small" @click="to_table(scope.row,'/experimental_results/view')" v-if="user_group == '管理员' || $check_action('/experimental_results/table','add') || $check_action('/experimental_results/view','add')">
						<span>输入成绩</span>
					</el-button>
							</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

								
		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/experimental_report/get_list?like=0",
				url_del: "~/api/experimental_report/del?",

				// 字段ID
				field: "experimental_report_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
										"course_name": "",
													"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
																								// 用户列表
				list_user_lecturer: [],
									// 用户列表
				list_user_student_name: [],
								}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},

			get_list_before(param){
				var user_group = this.user.user_group;
				if(user_group != "管理员"){
						let sqlwhere = "(";
																														if(user_group=="教师用户"){
						sqlwhere+= "lecturer = " + this.user.user_id + " or ";
					}
													if(user_group=="学生用户"){
						sqlwhere+= "student_name = " + this.user.user_id + " or ";
					}
																				if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						param["sqlwhere"] = sqlwhere;
					}
					}
				return param;
			},

																



												/**
			 * 获取教师用户用户列表
			 */
			async get_list_user_lecturer() {
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
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
						/**
			 * 获取学生用户用户列表
			 */
			async get_list_user_student_name() {
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
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
									deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
															this.get_list_user_lecturer();
								this.get_list_user_student_name();
							}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
