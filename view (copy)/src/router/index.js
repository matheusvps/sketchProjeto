import Vue from "vue";
import VueRouter from "vue-router";
import { RouteNames } from "./routes";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history",
  routes: [
    {
      path: RouteNames.HOME.PATH,
      name: RouteNames.HOME.NAME,
      component: () => import("@/views/HomeComp.vue"),
    },
    {
      path: RouteNames.STUDENT_LIST.PATH,
      name: RouteNames.STUDENT_LIST.NAME,
      component: () => import("@/components/StudentList.vue"),
    },
    {
      path: RouteNames.STUDENT_DETAILS.PATH,
      name: RouteNames.STUDENT_DETAILS.NAME,
      component: () => import("@/components/StudentCard.vue"),
    },
    {
      path: RouteNames.ADD_MARK.PATH,
      name: RouteNames.ADD_MARK.NAME,
      component: () => import("@/views/AddMark.vue"),
      props: true,
    },
    {
      path: RouteNames.ADD_STUDENT.PATH,
      name: RouteNames.ADD_STUDENT.NAME,
      component: () => import("@/views/StudentRegister.vue"),
    },
  ],
});

export default router;
