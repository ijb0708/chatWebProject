import customAxios from '@/api/axiosInit'

export const login = async (id, passwd) => {
    try {
        const user = await customAxios.post('/users/login', {
            user_id: id,
            user_password: passwd
        })
        return user.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const registerUser = async (id, nickname, passwd) => {
    try {
        const user = await customAxios.post('/users/register', {
            user_id: id,
            user_name: nickname,
            user_password : passwd
        })
        return user.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const idDupCheck = async (id) => {
    try {
        const is = await customAxios.get('/users/userIdDupCheck', {
            params: {
                user_id: id
            }
        })
        return is.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const registerRoom = async (roomname) => {
    try {
        const isSucc = await customAxios.post('/rooms/register', {
            room_name: roomname
        })
        return isSucc.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const enterRoom = async (roomSeq) => {
    try {
        const room = await customAxios.post('/rooms/enterRoom', {
            room_seq: roomSeq
        })
        return room.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const deleteRoom = async (roomSeq) => {
    try {
        const room = await customAxios.post('/rooms/enterRoom', {
            room_seq: roomSeq
        })
        return room.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const listRooms = async (pageNum, pageSize) => {
    try {
        const roomlist = await customAxios.get('/rooms/listRooms',{
            params: {
                pageNum: pageNum,
                pageSize: pageSize
            }
        })
        return roomlist.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const listAllRooms = async() => {
    try {
        const roomlist = await customAxios.get('/rooms/listAllRooms')
        return roomlist.data
    } catch (err) {
        console.log('err : ' + err)
    }
}

export const authCheck = async () => {
    try {
        const isSucc = await customAxios.get('/test/protected')
        return isSucc.data
    } catch (err) {
        console.log('err : ' + err)
    }
}