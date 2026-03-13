<template>
  <div class="curriculum-page">
    <!-- 方針説明 -->
    <section class="method-section">
      <h2>武田塾メソッド × IT英語</h2>
      <p class="method-desc">
        武田塾の「一冊を完璧に」の原則に基づき、段階的に英語力を積み上げます。
        各ステップは前のステップの土台の上に成り立つため、順番を守ることが重要です。
      </p>
      <div class="steps-explanation">
        <div class="step-card">
          <div class="step-number">1</div>
          <div class="step-detail">
            <h3>単語・文法</h3>
            <p>基礎語彙（NGSL + IT用語）と英文法の基礎を固める。単語は意味を即答できるレベルまで反復。</p>
          </div>
        </div>
        <div class="step-arrow">→</div>
        <div class="step-card">
          <div class="step-number">2</div>
          <div class="step-detail">
            <h3>英文解釈</h3>
            <p>1文ずつ構文を分析し、正確に読む力をつける。公式ドキュメントやREADMEの文を教材に使用。</p>
          </div>
        </div>
        <div class="step-arrow">→</div>
        <div class="step-card">
          <div class="step-number">3</div>
          <div class="step-detail">
            <h3>長文読解</h3>
            <p>実際のドキュメント・Issue・PRを通して、まとまった英文を速く正確に読む力を養う。</p>
          </div>
        </div>
      </div>
    </section>

    <!-- 進捗ロードマップ -->
    <section class="roadmap-section">
      <h2>学習ロードマップ</h2>
      <div class="roadmap">
        <div :class="['roadmap-step', { current: currentStep === 1, completed: currentStep > 1 }]">
          <div class="roadmap-header">
            <span class="roadmap-icon">{{ currentStep > 1 ? '✓' : '▶' }}</span>
            <h3>Step 1: 単語・文法</h3>
          </div>
          <div class="roadmap-body">
            <div class="progress-item">
              <span class="progress-label">単語習得</span>
              <div class="progress-bar">
                <div class="progress-fill vocabulary" :style="{ width: vocabPercent + '%' }"></div>
              </div>
              <span class="progress-text">{{ stats.mastered }} / {{ stats.total }}語 ({{ vocabPercent }}%)</span>
            </div>
            <div class="progress-item">
              <span class="progress-label">文法完了</span>
              <div class="progress-bar">
                <div class="progress-fill grammar" :style="{ width: grammarPercent + '%' }"></div>
              </div>
              <span class="progress-text">{{ grammarStats.completed }} / {{ grammarStats.total }}トピック ({{ grammarPercent }}%)</span>
            </div>
            <p class="step-condition">解放条件: 単語80%習得 かつ 文法全完了</p>
          </div>
        </div>

        <div :class="['roadmap-step', { current: currentStep === 2, locked: currentStep < 2 }]">
          <div class="roadmap-header">
            <span class="roadmap-icon">{{ currentStep < 2 ? '🔒' : '▶' }}</span>
            <h3>Step 2: 英文解釈</h3>
          </div>
          <div class="roadmap-body">
            <p class="step-preview">公式ドキュメントの1文を構文分析し、正確に読む練習</p>
            <p class="step-condition">解放条件: Step 1 完了</p>
          </div>
        </div>

        <div :class="['roadmap-step', { locked: currentStep < 3 }]">
          <div class="roadmap-header">
            <span class="roadmap-icon">🔒</span>
            <h3>Step 3: 長文読解</h3>
          </div>
          <div class="roadmap-body">
            <p class="step-preview">README・Issue・PRなど実践的な英文を読む練習</p>
            <p class="step-condition">解放条件: Step 2 完了</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { wordApi, grammarApi } from '../api/client'

const stats = ref({ total: 0, unknown: 0, learning: 0, mastered: 0 })
const grammarStats = ref({ total: 0, completed: 0 })

const vocabPercent = computed(() =>
  stats.value.total ? Math.round((stats.value.mastered / stats.value.total) * 100) : 0
)

const grammarPercent = computed(() =>
  grammarStats.value.total ? Math.round((grammarStats.value.completed / grammarStats.value.total) * 100) : 0
)

const currentStep = computed(() => {
  if (vocabPercent.value >= 80 && grammarStats.value.completed === grammarStats.value.total && grammarStats.value.total > 0) {
    return 2
  }
  return 1
})

onMounted(async () => {
  const [wordRes, grammarRes] = await Promise.all([
    wordApi.getStats(),
    grammarApi.getTopics()
  ])
  stats.value = wordRes.data
  const topics = grammarRes.data
  grammarStats.value = {
    total: topics.length,
    completed: topics.filter(t => t.completed).length
  }
})
</script>

<style scoped>
.curriculum-page {
  display: flex;
  flex-direction: column;
  gap: 32px;
}

.method-section h2,
.roadmap-section h2 {
  color: #fff;
  margin-bottom: 12px;
  font-size: 18px;
}

.method-desc {
  color: #aaa;
  font-size: 14px;
  line-height: 1.6;
  margin-bottom: 20px;
}

.steps-explanation {
  display: flex;
  align-items: center;
  gap: 12px;
}

.step-card {
  flex: 1;
  background: #2a2a4a;
  border-radius: 8px;
  padding: 16px;
  display: flex;
  gap: 12px;
  align-items: flex-start;
}

.step-number {
  width: 32px;
  height: 32px;
  background: #64b5f6;
  color: #1a1a2e;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  font-size: 16px;
  flex-shrink: 0;
}

.step-detail h3 {
  color: #fff;
  font-size: 15px;
  margin-bottom: 4px;
}

.step-detail p {
  color: #aaa;
  font-size: 13px;
  line-height: 1.5;
}

.step-arrow {
  color: #555;
  font-size: 24px;
  flex-shrink: 0;
}

/* ロードマップ */
.roadmap {
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.roadmap-step {
  background: #2a2a4a;
  border-radius: 8px;
  padding: 16px 20px;
  border-left: 4px solid #444;
}

.roadmap-step.current {
  border-left-color: #64b5f6;
}

.roadmap-step.completed {
  border-left-color: #81c784;
}

.roadmap-step.locked {
  opacity: 0.5;
}

.roadmap-header {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 12px;
}

.roadmap-icon {
  font-size: 16px;
}

.roadmap-header h3 {
  color: #fff;
  font-size: 15px;
}

.roadmap-body {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.progress-item {
  display: flex;
  align-items: center;
  gap: 10px;
}

.progress-label {
  color: #aaa;
  font-size: 13px;
  width: 64px;
  flex-shrink: 0;
}

.progress-bar {
  flex: 1;
  height: 8px;
  background: #1a1a2e;
  border-radius: 4px;
  overflow: hidden;
}

.progress-fill {
  height: 100%;
  border-radius: 4px;
  transition: width 0.3s;
}

.progress-fill.vocabulary { background: #81c784; }
.progress-fill.grammar { background: #64b5f6; }

.progress-text {
  color: #aaa;
  font-size: 12px;
  min-width: 120px;
}

.step-condition {
  color: #888;
  font-size: 12px;
  font-style: italic;
  margin-top: 4px;
}

.step-preview {
  color: #aaa;
  font-size: 13px;
}
</style>
