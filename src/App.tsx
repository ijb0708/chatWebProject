import { Component } from 'react';
import './App.css';
import { BottomNavigationAction, BottomNavigation, CssBaseline, Paper } from "@mui/material";
import { AccessAlarm } from '@mui/icons-material';
import MainHeader from "./components/MainHeader";
import LoginView from "./views/LoginView";

class App extends Component {
    render() {
        return (
            // <ThemeProvider theme={}>
            <>
                <CssBaseline />
                <MainHeader name={"test"} />
                <LoginView />
                <Paper sx={{ position: 'fixed', bottom: 0, left: 0, right: 0 }} elevation={3}>
                    <BottomNavigation
                        showLabels
                    >
                        <BottomNavigationAction label="Recents" icon={<AccessAlarm />} />
                        <BottomNavigationAction label="Favorites" icon={<AccessAlarm />} />
                        <BottomNavigationAction label="Archive" icon={<AccessAlarm />} />
                    </BottomNavigation>
                </Paper>
            </>
            // </ThemeProvider>
        )
    }
}

export default App;
