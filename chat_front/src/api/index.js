import * as requests from './requests'

export default {
    install(app) {
        app.config.globalProperties.$axios = {
            ...requests
        }
    }
}