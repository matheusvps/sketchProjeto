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
      path: RouteNames.ALL_LISTS.PATH,
      name: RouteNames.ALL_LISTS.NAME,
      component: () => import("@/components/lists/AllLists.vue"),
    },
    {
      path: RouteNames.STUDENT_LIST.PATH,
      name: RouteNames.STUDENT_LIST.NAME,
      component: () => import("@/components/lists/StudentList.vue"),
    },
    {
      path: RouteNames.STUDENT_DETAILS.PATH,
      name: RouteNames.STUDENT_DETAILS.NAME,
      component: () => import("@/components/cards/StudentCard.vue"),
    },
    {
      path: RouteNames.ADD_MARK.PATH,
      name: RouteNames.ADD_MARK.NAME,
      component: () => import("@/views/changes/AddMark.vue"),
      props: true,
    },
    {
      path: RouteNames.ADD_STUDENT.PATH,
      name: RouteNames.ADD_STUDENT.NAME,
      component: () => import("@/views/register/StudentRegister.vue"),
    },
    {
      path: RouteNames.ADD_TEACHER.PATH,
      name: RouteNames.ADD_TEACHER.NAME,
      component: () => import("@/views/register/TeacherRegister.vue"),
    },
    {
      path: RouteNames.ADD_EMPLOYEE.PATH,
      name: RouteNames.ADD_EMPLOYEE.NAME,
      component: () => import("@/views/register/EmployeeRegister.vue"),
    },
    {
      path: RouteNames.CHANGE_SUBJECT.PATH,
      name: RouteNames.CHANGE_SUBJECT.NAME,
      component: () => import("@/views/changes/ChangeSubject.vue"),
      props: true,
    },
    {
      path: RouteNames.EMPLOYEE_LIST.PATH,
      name: RouteNames.EMPLOYEE_LIST.NAME,
      component: () => import("@/components/lists/EmployeeList.vue"),
    },
    {
      path: RouteNames.TEACHER_LIST.PATH,
      name: RouteNames.TEACHER_LIST.NAME,
      component: () => import("@/components/lists/TeacherList.vue"),
    },
    {
      path: RouteNames.CHANGE_FUNCTION.PATH,
      name: RouteNames.CHANGE_FUNCTION.NAME,
      component: () => import("@/views/changes/ChangeFunction.vue"),
      props: true,
    },
    {
      path: RouteNames.TEACHER_DETAILS.PATH,
      name: RouteNames.TEACHER_DETAILS.NAME,
      component: () => import("@/components/cards/TeacherCard.vue"),
    },
    {
      path: RouteNames.EMPLOYEE_DETAILS.PATH,
      name: RouteNames.EMPLOYEE_DETAILS.NAME,
      component: () => import("@/components/cards/EmployeeCard.vue"),
    },
  ],
});

export default router;
