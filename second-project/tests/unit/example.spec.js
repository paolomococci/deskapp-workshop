import { expect } from 'chai'
import { shallowMount } from '@vue/test-utils'
import WelcomeComponent from '@/components/WelcomeComponent.vue'

describe('WelcomeComponent.vue', () => {
  it('renders props.titleOfPage when passed', () => {
    const titleOfPage = 'new message'
    const wrapper = shallowMount(WelcomeComponent, {
      propsData: { titleOfPage }
    })
    expect(wrapper.text()).to.include(titleOfPage)
  })
})
