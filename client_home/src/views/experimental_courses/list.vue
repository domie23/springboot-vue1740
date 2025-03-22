<template>
	<div class="diy_list page_experimental_courses" id="experimental_courses_list">
		<div class="warp">
			<div class="container diy_list_container">
				<div class="diy_list_title">
					<div class="col">
						<span class="title">实验课程列表</span>
					</div>
				</div>
				<div class="row diy_list_search">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">
							<span class="diy_list_search_title">关键字搜索：</span>
										<b-form-input size="sm" class="mr-sm-2" placeholder="实验室名搜索" v-model="query['laboratory_name']" />
											<b-form-input size="sm" class="mr-sm-2" placeholder="课程名称搜索" v-model="query['course_name']" />
									<b-form-input size="sm" class="mr-sm-2" placeholder="课程类别搜索" v-model="query['course_category']" />
												<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="diy_list_select_box">
					<span class="diy_list_select_title">下拉搜索：</span>
						<div class="diy_list_dropdown_box">
						<div class="col">
							<!-- 筛选 -->
							<div class="view">
																							<b-dropdown text="课程类别" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','course_category')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o,i) in list_course_category" @click="filter_set(o,'course_category')" >
										{{ o }}
										</b-dropdown-item>
								</b-dropdown>
														</div>
							<!-- /筛选 -->
						</div>
					</div>
					<div class="diy_list_sort_box">
						<div class="col">
							<!-- 排序 -->
							<div class="view">
								<b-dropdown text="排序" variant="outline-dark" left>
										<b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
												{{ o.name }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!--/排序 -->
						</div>
					</div>
				</div>

				<div class="row diy_list_box">
					<div class="col">
						<!-- 列表 -->
						<list_experimental_courses :list="list" />
						<!-- /列表 -->
					</div>
				</div>
				<div class="row diy_list_page_box">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
<!--						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>-->
            <b-pagination
                v-model="query.page"
                :total-rows="count"
                :per-page="query.size"
                @change="goToPage"
            />
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_experimental_courses from "@/components/diy/list_experimental_courses.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_experimental_courses
		},
		data() {
			return {
				url_get_list: "~/api/experimental_courses/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
										"laboratory_name": "", // 实验室名
													"course_name": "", // 课程名称
											"course_category": "", // 课程类别
											},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "create_time desc",
					},
					{
						name: "创建时间从低到高",
						value: "create_time asc",
					},
					{
						name: "更新时间从高到低",
						value: "update_time desc",
					},
					{
						name: "更新时间从低到高",
						value: "update_time asc",
					},
								{
						name: "实验室名正序",
						value: "laboratory_name asc",
					},
					{
						name: "实验室名倒序",
						value: "laboratory_name desc",
					},
									{
						name: "课程名称正序",
						value: "course_name asc",
					},
					{
						name: "课程名称倒序",
						value: "course_name desc",
					},
							{
						name: "课程类别正序",
						value: "course_category asc",
					},
					{
						name: "课程类别倒序",
						value: "course_category desc",
					},
									],

																	// 课程类别列表
				"list_course_category": ['化学','物理','其他'],
										
			}
		},
		methods: {
      get_list_before(param) {
      },
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},


											
			/**
			 * 筛选
			 */
																						filter_course_category(o) {
				if (o == "全部") {
					this.query["course_category"] = "";
				} else {
					this.query["course_category"] = o;
				}
				this.search();
			},
												/**
			 * 重置
			 */
			reset() {
									this.query.laboratory_name = ""
												this.query.course_name = ""
										this.query.course_category = ""
											this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},

      goToPage(v){
        this.query.page = v;
        this.goToNew(v)
      },

		},
		computed: {
		},
		created() {
																								}
	}
</script>

<style>
</style>
