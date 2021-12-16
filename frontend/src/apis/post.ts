import axios from "axios";
import { Post } from "../types";

export const getPosts = () => {
    return axios.get<Post[]>('http://localhost:8080/api/posts');
};

export const insertPost = (contents: string) => {
    return axios.post('http://localhost:8080/api/posts', { contents });
};
