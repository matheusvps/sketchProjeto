import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/students",
});

class StudentService {
  createStudent(student) {
    return axiosInstance.post("/", student);
  }

  updateStudent(id, studentData) {
    return axiosInstance.put(`/${id}`, studentData);
  }

  deleteStudent(id) {
    return axiosInstance.delete(`/${id}`);
  }

  getStudents() {
    return axiosInstance.get("/");
  }

  getStudentById(id) {
    return axiosInstance.get(`/${id}`);
  }

  addMark(id, nota) {
    return axiosInstance.post(`/${id}/${nota}`, nota);
  }

  getMarksNumber(id) {
    return axiosInstance.get(`/${id}/numero-notas`);
  }
}

export default new StudentService();
