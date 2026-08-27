import Axios,{ AxiosInstance } from "axios";

export const urlApi: AxiosInstance = Axios.create({
    baseURL: "http://localhost:8080"
})