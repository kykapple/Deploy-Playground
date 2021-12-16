import styled from "@emotion/styled";
import { ChangeEvent, useEffect, useState } from "react";

import { Post } from "../types";
import { getPosts, insertPost } from "../apis/post";
import PostList from "../components/PostList";

const Home = () => {
    const [contents, setContents] = useState<string>("");
    const [postList, setPostList] = useState<Post[]>([]);

    const inputContents = (event: ChangeEvent) => {
        setContents((event.target as HTMLInputElement).value);
    }

    const handleInsertButton = async () => {
        const post = await insertPost(contents);
        setPostList(prev => [ ...prev, post.data ]);
        setContents("");
    };

    useEffect(() => {
        (async () => {
            const postList = await getPosts();
            setPostList(JSON.parse(JSON.stringify(postList.data)));
        })();
    }, []);

    return (
        <Container>
            <div>
                <InputBar value={contents} onChange={inputContents}/>
                <InsertButton onClick={handleInsertButton}>등록</InsertButton>
            </div>
            <PostList postList={postList}/>
        </Container>
    );
};

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
    height: 100%;
    margin-top: 25px;
`;

const InputBar = styled.input`
    width: 348px;
    height: 50px;
    border: 2px solid rgb(144, 156, 226);
    border-radius: 16px;
    font-size: 15px;
    font-weight: 600;
    margin-right: 37px;
    padding-left: 20px;
    color: #000;
`;

const InsertButton = styled.button`
    width: 70px;
    height: 50px;
    border: none;
    border-radius: 16px;
    font-size: 15px;
    font-weight: 700;
    color: #000;
    cursor: pointer;
`;

export default Home;
