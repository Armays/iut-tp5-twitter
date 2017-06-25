
<template>
  <div>
    <textarea placeholder="Tapez un tweet" v-model="message"></textarea>
    <br>
    <button @click="postTweet()">Tweeter</button>
  </div>
</template>

<script>
import Vue from 'vue'
import Resource from 'vue-resource'


Vue.use(Resource)

export default {
  name: 'timeline',
  data () {
    return {
      message: undefined
    }
  },
  props: ['connectedUser'],
  methods: {
    postTweet: function() {
      this.$emit('newTweet', this.message);
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
