import { httpPost } from './http'

export const login = (data, params = {}) => httpPost({ url: '/api/auth/login', data, params})
