<template>
	<div class="diy_home diy_list diy_equipment_return" id="diy_equipment_return_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/equipment_return/details?equipment_return_id=' + o['equipment_return_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/equipment_return/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/equipment_return/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(item.name,o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
						<th class="diy_title" v-if="$check_field('get','equipment_number')">
						设备编号
					</th>
							<th class="diy_title" v-if="$check_field('get','device_name')">
						设备名称
					</th>
							<th class="diy_title" v-if="$check_field('get','equipment_classification')">
						设备分类
					</th>
							<th class="diy_title" v-if="$check_field('get','borrowing_teachers')">
						借用教师
					</th>
							<th class="diy_title" v-if="$check_field('get','return_quantity')">
						归还数量
					</th>
							<th class="diy_title" v-if="$check_field('get','contact_information')">
						联系方式
					</th>
							<th class="diy_title" v-if="$check_field('get','return_date')">
						归还日期
					</th>
							<th class="diy_title" v-if="$check_field('get','remarks')">
						备注
					</th>
					</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_text" v-if="$check_field('get','equipment_number')">
						<span>
							{{ o["equipment_number"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','device_name')">
						<span>
							{{ o["device_name"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','equipment_classification')">
						<span>
							{{ o["equipment_classification"] }}
						</span>
					</td>
							<td class="diy_field diy_uid" v-if="$check_field('get','borrowing_teachers')">
						<span>
							{{ get_user_name('borrowing_teachers',o['borrowing_teachers']) }}
						</span>
					</td>
							<td class="diy_field diy_number" v-if="$check_field('get','return_quantity')">
						<span>
							{{ o["return_quantity"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','contact_information')">
						<span>
							{{ o["contact_information"] }}
						</span>
					</td>
							<td class="diy_field diy_date" v-if="$check_field('get','return_date')">
						<span>
							{{ $toTime(o["return_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','remarks')">
						<span>
							{{ o["remarks"] }}
						</span>
					</td>
					</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						],
						itemList: [
								{
									title: "设备编号",
									name: "equipment_number",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "设备名称",
									name: "device_name",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "设备分类",
									name: "equipment_classification",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "借用教师",
									name: "borrowing_teachers",
									type: "UID",
									is_img_list: "0"
								},
								{
									title: "归还数量",
									name: "return_quantity",
									type: "数字",
									is_img_list: "0"
								},
								{
									title: "联系方式",
									name: "contact_information",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "归还日期",
									name: "return_date",
									type: "日期",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "备注",
									name: "remarks",
									type: "多文本"
								},
						],
								// 用户列表
				list_user_borrowing_teachers: [],
								};
		},
		methods: {
			get_user_name(name,id){
				var obj = null;
								if (name == 'borrowing_teachers'){
					obj = this.list_user_borrowing_teachers.getObj({"user_id":id});
				}
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
			 * 获取教师用户用户列表
			 */
			async get_list_user_borrowing_teachers() {
				var json = await this.$get("~/api/user/get_list?user_group=教师用户");
				if(json.result && json.result.list){
					this.list_user_borrowing_teachers = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
							},
		created() {
							this.get_list_user_borrowing_teachers();
							},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

