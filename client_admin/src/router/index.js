import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},



	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 学生用户路由
	{
		path: '/student_users/table',
		name: 'student_users_table',
		component: () => import('../views/student_users/table.vue'),
		meta: {
			index: 0,
			title: '学生用户列表'
		}
	},
	{
		path: '/student_users/view',
		name: 'student_users_view',
		component: () => import('../views/student_users/view.vue'),
		meta: {
			index: 0,
			title: '学生用户详情'
		}
	},
	// 教师用户路由
	{
		path: '/teacher_users/table',
		name: 'teacher_users_table',
		component: () => import('../views/teacher_users/table.vue'),
		meta: {
			index: 0,
			title: '教师用户列表'
		}
	},
	{
		path: '/teacher_users/view',
		name: 'teacher_users_view',
		component: () => import('../views/teacher_users/view.vue'),
		meta: {
			index: 0,
			title: '教师用户详情'
		}
	},
	// 实验课程路由
	{
		path: '/experimental_courses/table',
		name: 'experimental_courses_table',
		component: () => import('../views/experimental_courses/table.vue'),
		meta: {
			index: 0,
			title: '实验课程列表'
		}
	},
	{
		path: '/experimental_courses/view',
		name: 'experimental_courses_view',
		component: () => import('../views/experimental_courses/view.vue'),
		meta: {
			index: 0,
			title: '实验课程详情'
		}
	},
	// 课程预约路由
	{
		path: '/course_appointment/table',
		name: 'course_appointment_table',
		component: () => import('../views/course_appointment/table.vue'),
		meta: {
			index: 0,
			title: '课程预约列表'
		}
	},
	{
		path: '/course_appointment/view',
		name: 'course_appointment_view',
		component: () => import('../views/course_appointment/view.vue'),
		meta: {
			index: 0,
			title: '课程预约详情'
		}
	},
	// 预约时段路由
	{
		path: '/appointment_period/table',
		name: 'appointment_period_table',
		component: () => import('../views/appointment_period/table.vue'),
		meta: {
			index: 0,
			title: '预约时段列表'
		}
	},
	{
		path: '/appointment_period/view',
		name: 'appointment_period_view',
		component: () => import('../views/appointment_period/view.vue'),
		meta: {
			index: 0,
			title: '预约时段详情'
		}
	},
	// 实验报告路由
	{
		path: '/experimental_report/table',
		name: 'experimental_report_table',
		component: () => import('../views/experimental_report/table.vue'),
		meta: {
			index: 0,
			title: '实验报告列表'
		}
	},
	{
		path: '/experimental_report/view',
		name: 'experimental_report_view',
		component: () => import('../views/experimental_report/view.vue'),
		meta: {
			index: 0,
			title: '实验报告详情'
		}
	},
	// 实验成绩路由
	{
		path: '/experimental_results/table',
		name: 'experimental_results_table',
		component: () => import('../views/experimental_results/table.vue'),
		meta: {
			index: 0,
			title: '实验成绩列表'
		}
	},
	{
		path: '/experimental_results/view',
		name: 'experimental_results_view',
		component: () => import('../views/experimental_results/view.vue'),
		meta: {
			index: 0,
			title: '实验成绩详情'
		}
	},
	// 设备管理路由
	{
		path: '/device_management/table',
		name: 'device_management_table',
		component: () => import('../views/device_management/table.vue'),
		meta: {
			index: 0,
			title: '设备管理列表'
		}
	},
	{
		path: '/device_management/view',
		name: 'device_management_view',
		component: () => import('../views/device_management/view.vue'),
		meta: {
			index: 0,
			title: '设备管理详情'
		}
	},
	// 设备借用路由
	{
		path: '/equipment_borrowing/table',
		name: 'equipment_borrowing_table',
		component: () => import('../views/equipment_borrowing/table.vue'),
		meta: {
			index: 0,
			title: '设备借用列表'
		}
	},
	{
		path: '/equipment_borrowing/view',
		name: 'equipment_borrowing_view',
		component: () => import('../views/equipment_borrowing/view.vue'),
		meta: {
			index: 0,
			title: '设备借用详情'
		}
	},
	// 设备归还路由
	{
		path: '/equipment_return/table',
		name: 'equipment_return_table',
		component: () => import('../views/equipment_return/table.vue'),
		meta: {
			index: 0,
			title: '设备归还列表'
		}
	},
	{
		path: '/equipment_return/view',
		name: 'equipment_return_view',
		component: () => import('../views/equipment_return/view.vue'),
		meta: {
			index: 0,
			title: '设备归还详情'
		}
	},
	// 设备维修路由
	{
		path: '/equipment_maintenance/table',
		name: 'equipment_maintenance_table',
		component: () => import('../views/equipment_maintenance/table.vue'),
		meta: {
			index: 0,
			title: '设备维修列表'
		}
	},
	{
		path: '/equipment_maintenance/view',
		name: 'equipment_maintenance_view',
		component: () => import('../views/equipment_maintenance/view.vue'),
		meta: {
			index: 0,
			title: '设备维修详情'
		}
	},
	// 设备报停路由
	{
		path: '/equipment_shutdown/table',
		name: 'equipment_shutdown_table',
		component: () => import('../views/equipment_shutdown/table.vue'),
		meta: {
			index: 0,
			title: '设备报停列表'
		}
	},
	{
		path: '/equipment_shutdown/view',
		name: 'equipment_shutdown_view',
		component: () => import('../views/equipment_shutdown/view.vue'),
		meta: {
			index: 0,
			title: '设备报停详情'
		}
	},
	// 实验室信息路由
	{
		path: '/laboratory_information/table',
		name: 'laboratory_information_table',
		component: () => import('../views/laboratory_information/table.vue'),
		meta: {
			index: 0,
			title: '实验室信息列表'
		}
	},
	{
		path: '/laboratory_information/view',
		name: 'laboratory_information_view',
		component: () => import('../views/laboratory_information/view.vue'),
		meta: {
			index: 0,
			title: '实验室信息详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "实训中心管理系统-admin";
	document.title = title;
})

export default router
