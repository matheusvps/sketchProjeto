import Vue from "vue";
import Vuex from "vuex";
import StudentService from "../services/StudentService.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    students: [],
    currentStudent: null,
    marks: [],
    average: null,
    biggestMark: null,
    lowestMark: null,
    tests: null,
  },
  mutations: {
    SET_STUDENTS(state, students) {
      state.students = students;
    },
    SET_CURRENT_STUDENT(state, student) {
      state.currentStudent = student;
      state.average = student.average;
      state.biggestMark = student.biggestMark;
      state.lowestMark = student.lowestMark;
      state.tests = student.marks.length;
      console.log(student);
    },
    SET_STUDENT_NAME(state, name) {
      state.currentStudent.name = name;
    },
    SET_TESTS_NUMBER(state, tests) {
      state.tests = tests;
    },
    SET_AVERAGE(state, average) {
      state.average = average;
    },
    SET_BIGGEST_MARK(state, biggestMark) {
      state.biggestMark = biggestMark;
    },
    SET_LOWEST_MARK(state, lowestMark) {
      state.lowestMark = lowestMark;
    },
    SET_MARKS(state, marks) {
      state.marks = marks;
    },
  },

  actions: {
    async createStudent({ commit }, student) {
      const response = await StudentService.createStudent(student);
      commit("SET_CURRENT_STUDENT", response.data);
      const responseStudents = await StudentService.getStudents();
      commit("SET_STUDENTS", responseStudents.data);
    },

    async updateStudent({ commit }, student) {
      await StudentService.updateStudent(student.id, student);
      await commit("SET_CURRENT_STUDENT", student);
    },

    async deleteStudent({ commit }, student) {
      await StudentService.deleteStudent(student.id);
      await commit("SET_CURRENT_STUDENT", null);
      const responseStudents = await StudentService.getStudents();
      commit("SET_STUDENTS", responseStudents.data);
    },

    async getStudents({ commit }) {
      const response = await StudentService.getStudents({ cache: "no-cache" }); // adiciona o parâmetro cache: "no-cache"
      await commit("SET_STUDENTS", response.data);
    },

    async getStudentById({ commit }, id) {
      const response = await StudentService.getStudentById(id);
      await commit("SET_CURRENT_STUDENT", response.data);
    },

    async addMark({ commit }, { id, mark }) {
      await StudentService.addMark(id, mark);
      const response = await StudentService.getMarksNumber(id);
      await commit("SET_TESTS_NUMBER", response.data);
    },

    async getMarksNumber({ commit }, id) {
      const response = await StudentService.getMarksNumber(id);
      await commit("SET_MARKS", response.data);
    },
  },
});
