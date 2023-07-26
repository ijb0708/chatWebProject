import {ChangeEvent, Component} from "react";
import {Box, Button, Container, Link, TextField, Typography} from "@mui/material";

interface LoginFormProps {
    sendLoginDataToParent(userId: string, userPassword: string): void
}

interface LoginFormState {
    userId: string
    userPassword: string
}

class LoginForm extends Component<LoginFormProps, LoginFormState> {

    constructor(props :LoginFormProps) {
        super(props);
        this.state = {
            userId: '',
            userPassword: ''
        };

        this.onClickLogin = this.onClickLogin.bind(this);
        this.onClickRegister = this.onClickRegister.bind(this);
        this.onChangeValue = this.onChangeValue.bind(this);
    }

    onChangeValue(event :ChangeEvent<HTMLInputElement>) {
        // this.state[ event.target.id ] =  event.target.value;
        const { name, value } = event.target;
        // this.state.
        this.setState({
            ...this.state,
            [name]: value
        });
    }

    onClickLogin() {

        // alert("userId : " + this.state.userId + "\n"
        //     + "userPassword : " + this.state.userPassword);
        this.props.sendLoginDataToParent(
            this.state.userId,
            this.state.userPassword
        );

    }

    onClickRegister() {
        alert("link");
    }

    render() {
        const { userId, userPassword } = this.state;
        return (
            <Container
                component={"main"}
                maxWidth={"sm"}>
                <Box
                    sx={{
                        boxShadow: 3,
                        borderRadius: 2,
                        px: 4,
                        py: 6,
                        marginTop: 8,
                        display: "flex",
                        flexDirection: "Column",
                        alignItems: "center"
                    }}
                >
                    <Typography
                        component={"h1"}
                        variant={"h5"}
                    >
                        Sign in
                    </Typography>
                    <TextField
                        margin={"normal"}
                        id={"userId"}
                        name={"userId"}
                        label={"아이디"}
                        value={ userId }
                        fullWidth
                        required
                        onChange={ this.onChangeValue }
                    />
                    <TextField
                        margin={"normal"}
                        id={"userPassword"}
                        name={"userPassword"}
                        label={"비밀번호"}
                        value={ userPassword }
                        fullWidth
                        required
                        onChange={ this.onChangeValue }
                    />
                    <Button
                        sx={{ mt: 3, mb: 2}}
                        fullWidth
                        variant={"contained"}
                        onClick={ this.onClickLogin }
                    >
                        Sign In
                    </Button>
                    <Link
                        href="#"
                        variant="body2"
                        onClick={ this.onClickRegister }
                    >
                        {"Don't have an account? Sign Up"}
                    </Link>
                </Box>
            </Container>
        );
    }
}

export default LoginForm;