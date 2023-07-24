import { Component } from "react";
import {Box, Button, Container, Link, TextField, Typography} from "@mui/material";

interface LoginFormProps {

}

interface LoginFormState {
    userId: string
    password: string
}

class LoginForm extends Component<LoginFormProps, LoginFormState> {

    constructor(props :LoginFormProps) {
        super(props);
    }

    onClickLogin() {

    }

    onClickRegister() {

    }

    render() {
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
                        autoFocus
                        fullWidth
                        required
                    />
                    <TextField
                        margin={"normal"}
                        id={"userPasswd"}
                        name={"userPasswd"}
                        label={"비밀번호"}
                        autoFocus
                        fullWidth
                        required
                    />
                    <Button
                        sx={{ mt: 3, mb: 2}}
                        fullWidth
                        variant={"contained"}
                    >
                        Sign In
                    </Button>
                    <Link href="#" variant="body2">
                        {"Don't have an account? Sign Up"}
                    </Link>
                </Box>
            </Container>
        );
    }
}

export default LoginForm;