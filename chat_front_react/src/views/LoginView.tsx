import {Component} from 'react';
import LoginForm from "../components/LoginForm";
import MainHeader from "../components/MainHeader";
import { Box } from "@mui/material";
import { postLogin } from '../api';

interface loginViewProps {

}

interface loginViewState {

}

class LoginView extends Component<loginViewProps, loginViewState> {

    constructor(props: loginViewProps) {
        super(props);
    }

    handleLoginData(userId: string, userPassword: string) {
        console.log(userId + " " + userPassword);

        postLogin(userId, userPassword);

    }

    render() {
        return (
            <Box>
                <MainHeader name={"test"} />
                <LoginForm
                    sendLoginDataToParent={ this.handleLoginData }
                />
            </Box>
        );
    }
}

export default LoginView;