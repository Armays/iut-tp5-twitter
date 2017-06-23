<template>
  <div>
  <span v-if="loading === true">Chargement des tweets en cours...</span>
  <ul v-else>
    <li v-for="tweet in tweets">
      <tweet-comp :tweetProp="tweet"></tweet-comp>
    </li>
  </ul>
  </div>
</template>

<script>
import TweetComp from './TweetComp'
import Vue from 'vue'
import Resource from 'vue-resource'

Vue.use(Resource)
export default {
  name: 'timeline',
  data () {
            return {
                     tweets: [],
                     loading: true
                   }
          },
  created () {
    setTimeout(function(){
      this.fetchTweets()
      }.bind(this), 2000);
  },
  methods: {
    fetchTweets: function () {
      // GET /someUrl
        this.$http.get('http://localhost:8080/list').then(response => {

          // get body data
                          this.tweets = response.body;
                          this.loading = false;
        }, response => {
          // error callback
        });
    }
  },
  components: {TweetComp}
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
</style>
