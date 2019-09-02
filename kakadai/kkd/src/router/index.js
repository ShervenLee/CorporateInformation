import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Step1 from '@/components/Step1'
import Step2 from '@/components/Step2'
import Step3 from '@/components/Step3'
import Step4 from '@/components/Step4'
import Status from '@/components/Status'
Vue.use(Router)

export default new Router({
	routes: [{
			path: "/",
			name: "Login",
			component: Login
		},
		{
			path: "/home",
			name: "Home",
			component: Home
		},
		{
			path: "/step1",
			name: "Step1",
			component: Step1
		},
		{
			path: "/step2",
			name: "Step2",
			component: Step2
		},
		{
			path: "/step3",
			name: "Step3",
			component: Step3
		},
		{
			path: "/step4",
			name: "Step4",
			component: Step4
		},
		{
			path: "/status",
			name: "Status",
			component: Status
		}
	]
})