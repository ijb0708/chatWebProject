import {Component} from 'react';
import LoginForm from "../components/LoginForm";

interface loginViewProps {

}

interface loginViewState {

}

class LoginView extends Component<loginViewProps, loginViewState> {
    render() {
        return (
            <LoginForm />
        );
    }
}

export default LoginView;