import Vue from "vue";
import Vuex from "vuex";
import EmployeeService from "../services/EmployeeService.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    employees: [],
    currentEmployee: null,
    function: null,
  },
  mutations: {
    SET_EMPLOYEES(state, employee) {
      state.employee = employee;
    },
    SET_CURRENT_EMPLOYEE(state, employee) {
      state.currentEmployee = employee;
      state.function = employee.function;
      state.email = employee.email;
      state.age = employee.age;
      state.name = employee.name;
    },
    SET_EMPLOYEE_FUNCTION(state, EmpFunction){
        state.employeeFunction = EmpFunction;
    }
  },

  actions: {
    async createEmployee({ commit }, employee) {
      const response = await EmployeeService.createEmployee(employee);
      commit("SET_CURRENT_EMPLOYEE", response.data);
      const responseEmployees = await EmployeeService.getEmployees();
      commit("SET_EMPLOYEES", responseEmployees.data);
    },

    async updateEmployee({ commit }, employee) {
      await EmployeeService.updateEmployee(employee.id, employee);
      await commit("SET_CURRENT_EMPLOYEE", employee);
    },

    async deleteEmployee({ commit }, employee) {
      await EmployeeService.deleteEmployee(employee.id);
      await commit("SET_CURRENT_EMPLOYEE", null);
      const responseEmployees = await EmployeeService.getEmployees();
      commit("SET_EMPLOYEES", responseEmployees.data);
    },

    async getEmployees({ commit }) {
      const response = await EmployeeService.getEmployees({ cache: "no-cache" }); // adiciona o parâmetro cache: "no-cache"
      await commit("SET_EMPLOYEES", response.data);
    },

    async getEmployeeById({ commit }, id) {
      const response = await EmployeeService.getEmployeeById(id);
      await commit("SET_CURRENT_EMPLOYEE", response.data);
    },

    async getFunction({commit}, id){
        const response = await EmployeeService.getEmployeeFunction(id);
        await commit("SET")
      }
    },

});
