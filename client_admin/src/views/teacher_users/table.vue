<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


							<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="教师姓名">
									<el-input v-model="query.teachers_name"></el-input>
								</el-form-item>
				</el-col>
							<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/teacher_users/table','add') || $check_action('/teacher_users/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/teacher_users/table','del') || $check_action('/teacher_users/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
						<download-excel v-if="$check_option('/teacher_users/table','import_db')" class="export-excel-wrapper" :data="DetailsForm" :fields="json_fields" name="数据导入表格.xls" >
							<el-button type="success">下载导入文档</el-button>
						</download-excel>
						<el-upload v-if="$check_option('/teacher_users/table','import_db')" action accept = ".xlsx, .xls" :auto-upload="false" :show-file-list="false" :on-change="handle_import">
							<el-button type="primary">导入</el-button>
						</el-upload>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
			<el-table-column prop="username" label="用户名" width="120">
			</el-table-column>
				<el-table-column fixed prop="nickname" label="昵称">
				</el-table-column>
				<el-table-column prop="teachers_name" @sort-change="$sortChange" label="教师姓名"
				v-if="user_group == '管理员' || $check_field('get','teachers_name')" min-width="200">
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







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/teacher_users/table','set') || $check_action('/teacher_users/view','set') || $check_action('/teacher_users/view','get') || $check_action('//table','add') || $check_action('//view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/teacher_users/table','set') || $check_action('/teacher_users/view','set') || $check_action('/teacher_users/view','get')"
						:to="'./view?user_id=' + scope.row['user_id']"
						 size="small">
						<span>详情</span>
					</router-link>
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
	import * as XLSX from 'xlsx/xlsx.mjs'

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/teacher_users/get_list?like=0",
				url_del: "~/api/teacher_users/del?",

				// 字段ID
				field: "teacher_users_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
								"teachers_name": "",
								"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
				json_fields: {
					"账号":"username",
				"密码":"password",
				"昵称":"nickname",
				"手机号码":"phone",
				"邮箱":"email",
							"教师姓名":'teachers_name',
					},
				DetailsForm: [
					{
							"username":"填写账号",
						"password":"填写密码",
						"nickname":"填写昵称",
						"phone":"填写手机号码",
						"email":"填写邮箱",
								teachers_name:"账号类型",
						},
				],
						}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},
			delInfo() {
			    var list = this.selection;
			    if (list.length === 0) {
			        this.$message({
			            type: 'info',
			            message: '选择对象不能为空!'
			        });
			        return;
			    }
			    this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
			        confirmButtonText: '确定',
			        cancelButtonText: '取消',
			        type: 'warning'
			    }).then(async () => {
			        await this.delAll(list ,async (list)=>{
						var bl = true;
						for(var i=0; i < list.length; i++){
							var user_id = list[i].user_id;
							var res = await this.$get("~/api/user/del?",{user_id});
							if(res.result){
								console.log("删除成功" + i);
							}
							else{
								console.log("删除失败" + i);
								bl = false;
								break;
							}
						}
						if(bl){
							this.$message({
							    type: 'success',
							    message: '删除成功!'
							});
							this.get_list();
						}

					});
			    }).catch(() => {
			        this.$message({
			            type: 'info',
			            message: '已取消删除'
			        });
			    });
			},
			get_list_after(param){
				let _this = this;
				for (let i = 0;i<this.list.length;i++){
					let user_id = _this.list[i].user_id
					_this.$get("~/api/user/get_obj?", {
						user_id
					}, (json) => {
						if (json.result.obj){
							_this.$delete(_this.list[i],'username');
							_this.$set(_this.list[i],'username',json.result.obj.username);
							_this.$delete(_this.list[i],'nickname');
							_this.$set(_this.list[i],'nickname',json.result.obj.nickname);
						}
					});
				}
			},


		


	/**
	 * 导入
	 */
	readFile(file){//文件读取
		return new Promise(resolve => {
			let reader = new FileReader();
			reader.readAsBinaryString(file);//以二进制的方式读取
			reader.onload = ev =>{
				resolve(ev.target.result);
			}
		})
	},
	async handle_import(ev){
		let file = ev.raw;
		console.log(file)
		if(!file){
			console.log("文件打开失败")
			return ;
		}else{
			let data = await this.readFile(file);
			let workbook = XLSX.read(data,{ type: "binary"});//解析二进制格式数据
			let worksheet = workbook.Sheets[workbook.SheetNames[0]];//获取第一个Sheet
			let result = XLSX.utils.sheet_to_json(worksheet);//json数据格式
			result.forEach((item) => {
				// 将中文的键名替换成英文的
				for (let k in this.json_fields) {
					let newKey = this.json_fields[k];
					if (newKey) {
						item[newKey] = item[k];
						delete item[k];
					}
				}
			});
			let _this = this;
				for (let i=0;i<result.length;i++){
				let form_user = {};
				if (result[i].username){
					form_user.username = result[i].username;
				}
				delete result[i]["username"]
				if (result[i].password){
					form_user.password = result[i].password;
				}
				delete result[i]["password"]
				if (result[i].nickname){
					form_user.nickname = result[i].nickname;
				}
				delete result[i]["nickname"]
				if (result[i].phone){
					form_user.phone = result[i].phone;
				}
				delete result[i]["phone"]
				if (result[i].email){
					form_user.email = result[i].email;
				}
				delete result[i]["email"]
				form_user.user_group = "教师用户";
				await this.$post("~/api/user/add?", form_user, function (json, status) {
					if (json.result) {
						delete form_user["password"]
						_this.$get("~/api/user/get_obj?",form_user,(res)=>{
							if(res.result && res.result.obj){
								result[i].user_id = res.result.obj.user_id;
								_this.$post("~/api/teacher_users/add?", result[i], function (json, status) {
									if (json.result) {
										_this.$toast("操作成功", 'success');
									} else if (json.error) {
										_this.$toast(json.error.message, 'danger');
									}
								});
							}else if(res.error){
								this.$toast(res.error.message,"error");
							}
						})
					} else if (json.error) {
						_this.$toast(json.error.message, 'danger');
					}
				});
			}
			}
	},

					deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
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
