import { Component } from 'react';
import './App.css';
import { CssBaseline } from "@mui/material";
import LoginView from "./views/LoginView";

class App extends Component {
    render() {
        return (
            // <ThemeProvider theme={}>
            <>
                <CssBaseline />
                <LoginView />
            </>
            // </ThemeProvider>
        )
    }
}

export default App;
