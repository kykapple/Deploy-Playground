import styled from "@emotion/styled";
import {Post} from "../../types";

type Props = {
    postList: Post[]
};

const PostList = ({ postList }: Props) => {

    return (
        <Container>
            {postList.map((post: Post) => <PostBox key={post.id}>{post.contents}</PostBox>)}
        </Container>
    );
};

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const PostBox = styled.div`
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 460px;
    height: 40px;
    margin-top: 10px;
    padding-left: 20px;
    border-bottom: 1px solid #000;
`;

export default PostList;
