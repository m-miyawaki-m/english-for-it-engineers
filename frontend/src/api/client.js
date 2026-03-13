import axios from 'axios'

const api = axios.create({
  baseURL: '/api'
})

export const wordApi = {
  getWords(params = {}) {
    return api.get('/words', { params })
  },
  getWord(id) {
    return api.get(`/words/${id}`)
  },
  updateKnown(id, known) {
    return api.put(`/words/${id}/known`, { known })
  },
  getStats() {
    return api.get('/words/stats')
  },
  getRelations(id) {
    return api.get(`/words/${id}/relations`)
  },
  getRelationsBatch(wordIds) {
    return api.get('/words/relations', { params: { wordIds: wordIds.join(',') } })
  }
}

export const grammarApi = {
  getTopics() {
    return api.get('/grammar')
  },
  updateCompleted(id, completed) {
    return api.put(`/grammar/${id}/completed`, { completed })
  },
  getContent(id) {
    return api.get(`/grammar/${id}/content`)
  }
}
