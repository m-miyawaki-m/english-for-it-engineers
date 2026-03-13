import { createRouter, createWebHistory } from 'vue-router'
import Dashboard from '../views/Dashboard.vue'
import VocabularyStep from '../views/VocabularyStep.vue'
import GrammarStep from '../views/GrammarStep.vue'
import CurriculumPage from '../views/CurriculumPage.vue'
import Settings from '../views/Settings.vue'

const routes = [
  { path: '/', name: 'dashboard', component: Dashboard },
  { path: '/curriculum', name: 'curriculum', component: CurriculumPage },
  { path: '/vocabulary', name: 'vocabulary', component: VocabularyStep },
  { path: '/grammar', name: 'grammar', component: GrammarStep },
  { path: '/settings', name: 'settings', component: Settings },
]

const router = createRouter({
  history: createWebHistory('/english-for-it-engineers/'),
  routes
})

export default router
