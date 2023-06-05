import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/teachers",
});

class TeacherService {
  createTeacher(teacher) {
    return axiosInstance.post("/", teacher);
  }

  updateTeacher(id, teacherData) {
    return axiosInstance.put(`/${id}`, teacherData);
  }

  deleteTeacher(id) {
    return axiosInstance.delete(`/${id}`);
  }

  getTeachers() {
    return axiosInstance.get("/");
  }

  getTeacherById(id) {
    console.log(id);
    return axiosInstance.get(`/${id}`);
  }
  updateTeacherSubject(id, newSubject){
    return axiosInstance.put(`/${id}`, teacherData)
  }
}

export default new TeacherService();
