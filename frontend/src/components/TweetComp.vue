
<template>
  <div>{{ tweetProp.auteur.nom }} - {{tweetProp.auteur.prenom}} : {{tweetProp.contenu}}</div>
</template>

<script>

export default {
  name: 'TweetComp',
  props: ['tweetProp']
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
