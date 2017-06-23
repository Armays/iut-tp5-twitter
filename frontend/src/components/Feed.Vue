<template>
  <div>
  <span v-if="loading === true">Chargement des tweets en cours...</span>
  <ul v-else>
    <li v-for="tweet in tweets" class="tweet">
      <tweet-comp :tweetProp="tweet" @retweeted="retweet"></tweet-comp>
    </li>
  </ul>
  </div>
</template>

<script>
import TweetComp from './TweetComp'

export default {
  name: 'timeline',
  components: {TweetComp},
  props:['tweets', 'loading'],
  methods: {
     retweet: function (id) {
        this.$emit('retweeted', id)
     }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: block;
  margin: 0 10px;
}

li.tweet:first-child {
 border-top-width: 1px;
}

li.tweet {
 border-style: solid;
 border-width: 0 1px 1px 1px;
 border-color: gray;
 width: 500px;
 margin: auto;
}
</style>
