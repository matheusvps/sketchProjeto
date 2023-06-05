import Vue from "vue";
import Vuex from "vuex";
import TeacherService from "../services/TeacherService.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    teachers: [],
    currentTeacher: null,
    subject: null,
  },
  mutations: {
    SET_TEACHERS(state, teachers) {
      state.teachers = teachers;
    },
    SET_CURRENT_TEACHER(state, teacher) {
      state.currentTeacher = teacher;
      state.currentTeacher.name = teacher.name;
      state.subject = teacher.subject;
      state.currentTeacher.email= teacher.email
    },
    
    SET_TEACHER_SUBJECT(state, subject) {
      state.subject = subject;
    },
  },

  actions: {
    async createTeacher({ commit }, teacher) {
      const response = await TeacherService.createTeacher(teacher);
      commit("SET_CURRENT_TEACHER", response.data);
      const responseTeachers = await TeacherService.getTeachers();
      commit("SET_TEACHERS", responseTeachers.data);
    },

    async updateTeacher({ commit }, teacher) {
      await TeacherService.updateTeacher(teacher.id, teacher);
      await commit("SET_CURRENT_TEACHER", teacher);
    },

    async deleteTeacher({ commit }, teacher) {
      await TeacherService.deleteTeacher(teacher.id);
      await commit("SET_CURRENT_TEACHER", null);
      const responseTeachers = await TeacherService.getTeachers();
      commit("SET_TEACHERS", responseTeachers.data);
    },

    async getTeachers({ commit }) {
      const response = await TeacherService.getTeachers({ cache: "no-cache" }); // adiciona o parâmetro cache: "no-cache"
      await commit("SET_TEACHERS", response.data);
    },

    async getTeacherById({ commit }, id) {
      const response = await TeacherService.getTeacherById(id);
      await commit("SET_CURRENT_TEACHER", response.data);
    },

    async getSubject({commit}, id){
      const response = await TeacherService.getTeacherSubject(id);
      await commit("SET")
    }
  },
});
